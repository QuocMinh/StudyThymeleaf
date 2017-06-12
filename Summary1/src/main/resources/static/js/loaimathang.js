alert("jashdjsakh");

$(document).ready(function() {
    $('.clickable').on('click', function() {
    	alert("sadjhaskj");
        // Dung bien gia tri trong <td> vao cac bien
        var $maLoai = $(this).find('td:nth-child(2)').text();
        var $tenLoai = $(this).find('td:nth-child(3)').text();
        var $moTa = $(this).find('td:nth-child(4)').text();

        // Set gia tri cho cac input con lai
        $('#maLoai').val($maLoai);
        $('#tenLoai').val($tenLoai);
        $('#moTa').val($moTa);

        // Set duong dan cho nut Delete
        var link = $('#btnDelete').attr('href') + "?id=" + $maLoai;
        $('#btnDelete').attr('href', link);
    });

    scrolify($('#tbl-loaihanghoa'), 380); // 160 is height
    
    changePageAndSize();
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		window.location.replace("/list-product-type?pageSize=" + this.value + "&page=1");
	});
}

function scrolify(tblAsJQueryObject, height){
    var oTbl = tblAsJQueryObject;

    // for very large tables you can remove the four lines below
    // and wrap the table with <div> in the mark-up and assign
    // height and overflow property  
    var oTblDiv = $("<div/>");
    oTblDiv.css('height', height);
    oTblDiv.css('overflow','auto');               
    oTbl.wrap(oTblDiv);

    // save original width
    oTbl.attr("data-item-original-width", oTbl.width());
    oTbl.find('thead tr td').each(function(){
        $(this).attr("data-item-original-width",$(this).width());
    }); 
    oTbl.find('tbody tr:eq(0) td').each(function(){
        $(this).attr("data-item-original-width",$(this).width());
    });                 

    // clone the original table
    var newTbl = oTbl.clone();

    // remove table header from original table
    oTbl.find('thead').remove();                 
    // remove table body from new table
    newTbl.find('tbody').remove();   

    oTbl.parent().parent().prepend(newTbl);
    newTbl.wrap("<div/>");

    // replace ORIGINAL COLUMN width                
    newTbl.width(newTbl.attr('data-item-original-width'));
    newTbl.find('thead tr td').each(function(){
        $(this).width($(this).attr("data-item-original-width"));
    });     
    oTbl.width(oTbl.attr('data-item-original-width'));      
    oTbl.find('tbody tr:eq(0) td').each(function(){
        $(this).width($(this).attr("data-item-original-width"));
    });                 
}

