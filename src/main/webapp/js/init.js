$('.carousel.carousel-slider').carousel({
   fullWidth: true,
   padding: 200
 }, setTimeout(autoplay, 4500));

 function autoplay() {
   $('.carousel').carousel('next');
   setTimeout(autoplay, 4500);
 }