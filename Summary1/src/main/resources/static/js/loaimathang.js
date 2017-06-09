$(document).ready(function() {
    $('.clickable').on('click', function() {
        // Set id cho intput id
        var $id = $(this).attr('id'); // Get id from <tr>

        // Dung bien gia tri trong <td> vao cac bien
        var $maLoai = $(this).find('td:nth-child(2)').text();
        var $tenLoai = $(this).find('td:nth-child(3)').text();
        var $moTa = $(this).find('td:nth-child(4)').text();

        // Set gia tri cho cac input con lai
        $('#idLoaiMatHang').val($id);
        $('#maLoai').val($maLoai);
        $('#tenLoai').val($tenLoai);
        $('#moTa').val($moTa);

        // Set duong dan cho nut Delete
        var link = $('#btnDelete').attr('href') + "?id=" + $id;
        $('#btnDelete').attr('href', link);
    });

    $('#btnDelete').on('click', function() {

    });
});
