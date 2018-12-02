/**
 * 
 */


var addCols = function (num){
    for (var i=1;i<=num;i++) {
    	
        var myCol = $('<div class="col-sm-3 col-md-3 pb-2"></div>');
        var myPanel = $('<div class="card"><img class="card-img-top"src="data:image/;base64,${asd.getBase64image()}"alt="Card image cap"><div class="card-body"><h5 class="card-title">${asd.getTitle()}</h5><h1>$(a)</h1><p class="card-text">${asd.getCaption()}</p><p class="card-text"><small class="text-muted">Uploaded By:${asd.getUsername()}</small></p></div></div>');
        myPanel.appendTo(myCol);
        myCol.appendTo('#contentPanel');
    }
    
    
    $('.close').on('click', function(e){
      e.stopPropagation();  
          var $target = $(this).parents('.col-sm-3');
          $target.hide('slow', function(){ $target.remove(); });
    });
};

$('#btnGen').click(function(){
    addCols($('#numPanels').val());
    return false;
});

