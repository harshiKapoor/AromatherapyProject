$(document).ready(function(){

  $('#header_menuicon').click(function() {
      $('#header_nav').toggleClass('hide');
  });

  if($(window).width() >= 600) {
      $('#header_nav').removeClass('hide');
  };

  $('.header_nav-listItem').hover(function() {
    $('.header_nav-listItem-link').fadeIn('slow');
  });
  // click product buy button
  $('.product_buy').on('click',function(){
    alert("Adding"+ " "+ $(this).siblings('img').attr('alt')+" "+"To Your Shopping Cart");
  });

  // selecting currency from currency drop down
  $('#product_currencies').change(function() {
      var selectedCurrency = $('#product_currencies').val();
      switch(selectedCurrency) {
        case 'NZ Dollar':
          $('#product_details p').each(function(i, current) {
             var slicedText = $(current).text().substring(4,6);
              var convertedPrice = (Number(slicedText)+.07);
              $(current).text("NZ"+" "+"$"+convertedPrice);
          });
            break;

        case 'AU Dollar':
        $('#product_details p').each(function(i, current) {
           var slicedText = $(current).text().substring(4,6);
            var convertedPrice = (Number(slicedText)+.07-.07);
            $(current).text("AU"+" "+"$"+convertedPrice);
        });
            break;
      }
  });


  // selecting location from location drop down
  $('#location_suburbs').change(function(){
     var selectedLocation = $('#location_suburbs').val();
     var timeslots = $('#session_bookingForm-timeslots');
      $.ajax({
        url: 'http://localhost:3000/shops',
        type: 'get',
        dataType: 'jsonp',
        data:{
          id: selectedLocation
        },
        success: function(data){
          $('#shop').val((data[0].id));
          $('#address').val((data[0].address));
          $('#contact').val((data[0].contact));
          $('#phone').val((data[0].phone));
          timeslots.empty();
          timeslots.append($("<option></option> ")
                          .attr("value",'').text('Please select'));
          $.each(data[0].timeslots, function(index,value){
            timeslots.append($("<option></option>")
                            .attr("value",'').text(value));
          });
        }
      });
    });

    // confirming booking - click submit button
    $('#book').click(function(e){
      e.preventDefault();
      var custName = $("#custName").val();
      var custPhone = $("#custPhone").val();
      var selectedTherapy = "Sea salt"   //$("#session_bookingForm-therapy").val();
      var selectedTime =  "9:00"    //$("#session_bookingForm-timeslots").val();
      var selectedLocation = "Newmarket"  //$("location").val();
      var id = Math.floor(Math.random()*100)+1;

        $.ajax({
          url: 'http://localhost:3000/orders',
          type: 'post',
          dataType: 'json',
          data: {
              id:id,
              custName: custName,
              custPhone: custPhone,
              order: selectedTherapy,
              time: selectedTime,
              location: selectedLocation
          }
        })
          .then(function(data){
            console.log(data);
            // var msg = "Therapy:"+""+data[0].order+
            //           +"Time:"+""+data[0].time+
            //           +"at"+""+data[0].location;
            // $('.order').html("hello").css("opacity","1");
          });
    });

  });
