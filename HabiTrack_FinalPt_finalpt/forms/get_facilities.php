<?php
// Connect to your database
$host = "localhost";   // Your server (XAMPP default)
$user = "root";        // Default XAMPP username
$pass = "";            // Default password (empty)
$dbname = "habitrack"; // Change this to your actual database name

// Create connection
$conn = new mysqli($host, $user, $pass, $dbname);

// Check connection
if ($conn->connect_error) {
    die(json_encode(["error" => "Database connection failed: " . $conn->connect_error]));
}

// Query all facilities from your table
$sql = "SELECT name, category, lat, lng FROM facilities";
$result = $conn->query($sql);

$facilities = [];

if ($result && $result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $facilities[] = [
            "name" => $row["name"],
            "category" => $row["category"],
            "lat" => (float)$row["lat"],
            "lng" => (float)$row["lng"]
        ];
    }
}

echo json_encode($facilities);

$conn->close();
?>