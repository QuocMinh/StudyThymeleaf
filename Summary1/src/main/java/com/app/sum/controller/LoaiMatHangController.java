package com.app.sum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.sum.model.LoaiMatHang;
import com.app.sum.repository.LoaiMatHangRepository;
import com.mongodb.DuplicateKeyException;

@Controller
@RequestMapping("/loai-mat-hang")
public class LoaiMatHangController {
	
	@Autowired
	LoaiMatHangRepository loaiMHRepo;

	@GetMapping("/list")
	public String showAll(Model model) {
		List<LoaiMatHang> loaiMHs = loaiMHRepo.findAll();
		
		model.addAttribute("loaiMHs", loaiMHs);
		model.addAttribute("loaiMHNew", new LoaiMatHang());
		
		
		return "loaimathang-list";
	}
	
	@PostMapping("/update")
	public String handleUpdate(@ModelAttribute LoaiMatHang loaiMH,
			HttpServletRequest request) {
		String id = request.getParameter("idLoaiMatHang");
		
		if("".equals(id)) { // Neu id = null -> Save
			LoaiMatHang loaiMHNew = new LoaiMatHang(
					loaiMH.getMaLoai(),
					loaiMH.getTenLoai(),
					loaiMH.getMoTa());
			
			try {
				loaiMHRepo.save(loaiMHNew);
			} catch (DuplicateKeyException e) {
				e.printStackTrace();
			}
			
		} else { // Nguoc lai -> Update
			 loaiMHRepo.save(loaiMH);
		}
		
		return "redirect:/loai-mat-hang/list";
	}
	
	
	@GetMapping("/delete")
	public String handleDelete(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		System.out.println(id);
		
		loaiMHRepo.delete(id);
		
		return "redirect:/loai-mat-hang/list";
	}
	
	/**
	 * Save LoaiMathang if it doesn't existed yet
	 * <br>
	 * 
	 * @param maLoai : Model
	 * @return
	 * <ul>
	 * 	<li>FALSE	: If LoaiMathang already exists</li>
	 * 	<li>TRUE	: If save LoaiMathang successfully</li>
	 * </ul>
	 */
	public boolean saveLoaiHangHoa(LoaiMatHang maLoai) {
		// Get account by username:
		LoaiMatHang acc = loaiMHRepo.findByMaLoai(maLoai.getMaLoai());
		boolean accountExisted = false;
		
		try {
			// Check account existed
			accountExisted = loaiMHRepo.exists(acc.getId());
		} catch (NullPointerException e) {
			System.out.println("LoaiMathang chua ton tai");
		}
		
		if(accountExisted) {
			System.out.println("LoaiMathang da ton tai");
		} else {
			loaiMHRepo.save(maLoai);
			System.out.println("LoaiMathang saved");
			
			return true;
		}
		
		return false;
	}
	
}
