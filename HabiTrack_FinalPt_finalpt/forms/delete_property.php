<?php
$host = "localhost";
$user = "root";
$pass = "";
$dbname = "habitrack";

$conn = new mysqli($host, $user, $pass, $dbname);
if ($conn->connect_error) {
  die("Database connection failed: " . $conn->connect_error);
}

if (!isset($_POST['id'])) {
  die("No property ID provided.");
}

$id = intval($_POST['id']);

// Delete record
$sql = "DELETE FROM properties WHERE id = $id";
if ($conn->query($sql) === TRUE) {
  echo "Property deleted successfully.";
} else {
  echo "Error deleting property: " . $conn->error;
}

$conn->close();
?>
