$(document).ready(function(){
    $.ajax({
        url: "/Koperasi/karyawanCtr",
        method: "GET",
        dataType: "json",
        success:
                function(data){
                    $("#tabelkaryawan").dataTable({
                        serveside: true,
                        processing: true,
                        data:data,
                        sort:true,
                        searching:true,
                        paging:true,
                        columns:[
                            {'data':'nik','name':'nik','type':'string'},
                            {'data':'nama'},
                            {'data':'gender'},
                            {'data':'tmpLahir'},
                            {'data':'tglLahir', className:'text-center'},
                            {'data':'telepon'},
                            {'data':null, 'className':'dt-right',
                            'mRender':function(o){
                                return "<a class= 'btn btn-outline-success btn-sm'"
                                +"id='btnEdit'>EDIT</a>"
                                +"&nbsp;&nbsp;"
                                +"<a class='btn btn-outline-danger btn-sm'"
                                +"id='btnDel'>HAPUS</a>";
                            }
                        }
                        ]
                    });
                    }
                });
    });