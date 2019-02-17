document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.carousel');
    var instances = M.Carousel.init(elems, {});
    $('.carousel').carousel({
    padding: 200    
});
autoplay();
function autoplay() {
    $('.carousel').carousel('next');
    setTimeout(autoplay, 4500);
}
  });
