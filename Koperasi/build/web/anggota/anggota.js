$(document).ready(function(){
   var noanggota, nama, tmplahir, tgllahir, alamat, telepon, gender, page, nik;
   
   $('#backHome').click(function(){
      window.history.back(); 
   });
   
   $.ajax({
       url: '/Koperasi/anggotaCtr',
       method: "GET",
       dataType: "json",
       success:
               function(data){
                   $("#tabelanggota").dataTable({
                       serverside: true,
                       processing: true,
                       data: data,
                       sort: true,
                       searching: true,
                       paging: true,
                       columns:[
                           {'data': 'noanggota','name':'noanggota','type':'string'},
                           {'data': 'nama'},
                           {'data': 'gender'},
                           {'data': 'tmplahir'},
                           {'data': 'tgllahir', className: 'text-center'},
                           {'data': 'alamat'},
                           {'data': 'telepon'},
                           {'data': null, 'className': 'dt-right',
                               'mRender': function(o){
                                   return "<a class='btn btn-outline-success btn-sm'"
                                   +"id='btnEdit'>Edit</a>"
                                   +"&nbsp;&nbsp;"
                                   +"<a class='btn btn-outline-danger btn-sm'"
                                   +"id='btnDel'>Delete</a>"
                               }
                           }
                       ]
                   });
               }
   })
   
   function getInputValue(){
        noanggota = $('#noanggota').val();
        nama = $("#nama").val();
        gender = $("#gender").children("option:selected").val();
        tmplahir = $("#tmplahir").val();
        tgllahir = $("#tgllahir").val();
        alamat = $("#alamat").val();
        telepon = $("#telepon").val();
   }
   
   $('#sidebarBuka').click( function() {
        $('#sidebar').toggleClass('active');
        console.log("slide-slide");
    });
   
   
   $("#btnAdd").click(function(){
       $('#btnSave').html('SIMPAN');
       $("#myModal").fadeIn();
       $("#titel1").show();
       $("#titel2").hide();
       $("#nomoranggota").prop('disabled',false);
       page="tambah";
    });
    
    $('#tabelanggota tbody').on('click','#btnEdit', function(){
        $("#myModal").fadeIn();
        $("#titel1").hide();
        $("#titel2").show();
        $('#noanggota').prop('disabled',true);
        $('#btnSave').html('EDIT');
        page="tampil";
        var baris = $(this).closest('tr');
        var noanggota = baris.find('td:eq(0)').text();
        $.post('/Koperasi/anggotaCtr', {
                page: page,
                noanggota: noanggota
            },  
             function(data, status){
                 console.log(page);
                 console.log(data);
                 $('#noanggota').val(data.noanggota);
                 $('#nama').val(data.nama);
                 $('#gender').val(data.gender);
                 $('#tmplahir').val(data.tmplahir);
                 $('#tgllahir').val(data.tgllahir);
                 $('#alamat').val(data.alamat);
                 $('#telepon').val(data.telepon);
             }
        );  
        page="edit";
        console.log(page);
     });
    
    $("#btnSave").click(function(){
       getInputValue();
       console.log(page);
       if(noanggota === ""){
           $("#noanggota").css("border-color","red");
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Nomor Anggota Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#noanggota").focus();
                           $("#noanggota").keypress(function(){
                                $("#noanggota").css("border-color","black")
                           })
                       }
                   }
               }
           })
       }else if(nama === ""){
           $("#nama").css("border-color","red");
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Nama Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#nama").focus();
                           $("#nama").keypress(function(){
                                $("#nama").css("border-color","black")
                           })
                       }
                   }
               }
           })
       }else{
           if(getAge() < 0){
                $.alert({
                icon : 'far fa-times-circle',
                title: 'Gagal',
                type: 'red',
                content: "Maaf Anda Belum Lahir",
                typeAnimated: true,
                buttons: {
                    ok: {
                        btnClass: 'btn-red',
                        action: function(){  
                        }  
                    }          
                }
            });
           }
           else if(getAge() < 17){
               $.alert({
                icon : 'far fa-times-circle',
                title: 'Gagal',
                type: 'red',
                content: "Minimal usia adalah 17 tahun, usia anda "+ getAge() + " Tahun",
                typeAnimated: true,
                buttons: {
                    ok: {
                        btnClass: 'btn-red',
                        action: function(){  
                        }  
                    }          
                }
            });
           }else{
            $.post('/Koperasi/anggotaCtr', {
                page: page,
                noanggota: noanggota,
                nama: nama,
                gender: gender,
                tmplahir: tmplahir,
                tgllahir: tgllahir,
                alamat: alamat,
                telepon: telepon
            },
                 function(data, status){ 
                     console.log(data);
                     if(data === "Data berhasil disimpan, OK..."){
                         $.alert({
                             icon : 'fas fa-check-circle',
                             title: 'Berhasil',
                             type: 'blue',
                             content: data,
                             typeAnimated: true,
                             buttons: {
                                 ok: {
                                     btnClass: 'btn-red',
                                     action: function(){
                                         location.reload();   
                                     }  
                                 }          
                             }
                         });
                     }else if(data === "Data Berhasil di Edit"){
                         $.alert({
                             icon : 'fas fa-check-circle',
                             title: 'Berhasil',
                             type: 'blue',
                             content: data,
                             typeAnimated: true,
                             buttons: {
                                 ok: {
                                     btnClass: 'btn-red',
                                     action: function(){
                                         location.reload();   
                                     }  
                                 }          
                             }
                         });
                     }else{
                       $.alert({
                             icon : 'far fa-times-circle',
                             title: data,
                             type: 'red',
                             content: data,
                             typeAnimated: true,
                             buttons: {
                                 ok: {
                                     btnClass: 'btn-red',
                                     action: function(){  
                                     }  
                                 }          
                             }
                         });  
                     }                    
                 }
             );
            }
       }
    });
    
    $("#btnCancel").click(function(){
        $("#myModal").fadeOut(); 
        $('#noanggota').val("");
        $('#nama').val("");
        $('#gender').val("");
        $('#tmplahir').val("");
        $('#tgllahir').val("");
        $('#alamat').val("");
        $('#telepon').val("");
    });
    
    
    $('#tabelanggota tbody').on('click','#btnDel', function(){
       var baris = $(this).closest('tr');
       var noanggota = baris.find("td:eq(0)").text();
       console.log(noanggota);
       var nama = baris.find("td:eq(1)").text();
       page="hapus";
       
       $.confirm({
            title: 'Warning!',
            content: 'Apakah anda yakin ingin menghapus No Anggota '+noanggota+" - " + nama +" ?",
            buttons: {
                yes: {
                    btnClass: 'btn-red',
                    action: function(data, status){
                                $.post('/Koperasi/anggotaCtr', {
                                    page: page,
                                    noanggota: noanggota
                                },
                                function(data, status){
                                   if(data === "Data Berhasil di Hapus"){ 
                                   $.alert({
                                        title: 'Berhasil!',
                                        content: data,
                                        buttons: {
                                            ok: {
                                                btnClass: 'btn-red',
                                                action: function(){
                                                    location.reload();
                                                }
                                            }
                                        }
                                    }) 
                                }
                            }
                                    
                        )
                    }
                },
                No:{
                    btnClass: 'blue',
                    action: function(){
                        
                    }
                }
            }
       })
    });
    
     
     $("#noanggota, #telepon").keypress(function(data){
            if(data.which!=8 && data.which!=0 && (data.which<48 || data.which>57))
            {
                $("#pesan").html("isikan angka").show().fadeOut("slow");
                return false;
            }
    });
    
    function getAge() {
        var date = document.getElementById('tgllahir').value;
	var today = new Date();
	var birthday = new Date(date);
	var year = 0;
	if (today.getMonth() < birthday.getMonth()) {
            year = 1;
	} else if ((today.getMonth() == birthday.getMonth()) && today.getDate() < birthday.getDate()) {
            year = 1;
	}
	var age = today.getFullYear() - birthday.getFullYear() - year;
	return age;
    }
});
