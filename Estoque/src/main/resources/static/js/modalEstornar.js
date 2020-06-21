$(".modal-estornar").click(function() {
	
    var button    = $(this);
    var descricao = button.data('descr');
    var modal     = $("#modalEstornar");

    modal.find('.modal-content p').html('Deseja realmente estornar : <strong>'  + descricao + '</strong> ?');

    $('#btnModalSim').click(function(){
        $(button).find('form').submit();
    });
    
    modal.modal('open');
});