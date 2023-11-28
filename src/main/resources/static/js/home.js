document.addEventListener('DOMContentLoaded', function() {
    const dropdownToggle = document.getElementById('dropdown-toggle');
    const dropdownMenu = document.querySelector('.dropdown');

    dropdownToggle.addEventListener('click', function() {
        // Toggle the dropdown visibility
        dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
    });
});
