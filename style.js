const pages = document.querySelectorAll('.page');
const navLinks = document.querySelectorAll('nav ul li a');
let currentPage = 0;

// Function to navigate to a specific page
function navigateTo(index) {
    pages[currentPage].classList.remove('active');
    navLinks[currentPage].classList.remove('active');

    currentPage = index;

    pages[currentPage].classList.add('active');
    navLinks[currentPage].classList.add('active');
}

// Event listeners for navigation links
navLinks.forEach((link, index) => {
    link.addEventListener('click', (event) => {
        event.preventDefault();
        navigateTo(index);
    });
});

// Swipe gesture detection
let startX;

document.addEventListener('touchstart', (event) => {
    startX = event.touches[0].clientX;
});

document.addEventListener('touchmove', (event) => {
    const endX = event.touches[0].clientX;
    if (startX - endX > 50) {
        // Swipe left
        if (currentPage < pages.length - 1) {
            navigateTo(currentPage + 1);
        }
    } else if (endX - startX > 50) {
        // Swipe right
        if (currentPage > 0) {
            navigateTo(currentPage - 1);
        }
    }
});
