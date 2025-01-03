<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to WishApp</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Welcome to <span class="highlight">WishApp</span></h1>
    </header>
    <nav>
        <ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
        </ul>
    </nav>
    <main>
        <!-- Home Section -->
        <section id="home" class="page-section">
            <h2>Your one-stop solution for all your wishes!</h2>
            <p>Explore our features and make your wishes come true.</p>
            <section>
                <h3>Our Services</h3>
                <ul>
                    <li>Wish Management</li>
                    <li>Personalized Recommendations</li>
                    <li>24/7 Customer Support</li>
                </ul>
            </section>
            <button class="cta-button">Get Started</button>
        </section>

        <!-- About Section -->
        <section id="about" class="page-section">
            <h2>Our Story</h2>
            <p>
                WishApp was founded in 2023 with a mission to bring dreams closer to reality. 
                Our innovative platform enables users to manage their wishes efficiently and make informed decisions.
            </p>
            <h3>Meet the Team</h3>
            <ul>
                <li><strong>John Doe</strong> - CEO & Founder</li>
                <li><strong>Jane Smith</strong> - CTO</li>
                <li><strong>Emily White</strong> - Lead Designer</li>
            </ul>
        </section>

        <!-- Contact Section -->
        <section id="contact" class="page-section">
            <h2>Get in Touch</h2>
            <p>We’d love to hear from you! Fill out the form below to reach us.</p>
            <form action="wish" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required><br>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br>
                <label for="message">Message:</label><br>
                <textarea id="message" name="message" rows="5" required></textarea><br>
                <button type="submit">Submit</button>
            </form>
        </section>
    </main>
    <footer>
        <p>&copy; 2023 WishApp. All rights reserved.</p>
    </footer>
</body>
</html>
