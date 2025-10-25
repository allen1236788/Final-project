<?php
header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");

$host = "localhost";
$user = "root";
$pass = "";
$dbname = "habitrack";

$conn = new mysqli($host, $user, $pass, $dbname);
if ($conn->connect_error) {
    echo json_encode(["error" => "DB connection failed: " . $conn->connect_error]);
    exit;
}

$data = [
    "houseLocations" => [],
    "landLocations" => [],
    "houseNames" => [],
    "landNames" => [],
    "priceRanges" => []
];

// 🏠 Fetch house data
$houseLoc = $conn->query("SELECT DISTINCT location FROM properties WHERE type = 'House'");
while ($row = $houseLoc->fetch_assoc()) $data["houseLocations"][] = $row["location"];

$landLoc = $conn->query("SELECT DISTINCT location FROM properties WHERE type = 'Land'");
while ($row = $landLoc->fetch_assoc()) $data["landLocations"][] = $row["location"];

$houseNames = $conn->query("SELECT DISTINCT name FROM properties WHERE type = 'House'");
while ($row = $houseNames->fetch_assoc()) $data["houseNames"][] = $row["name"];

$landNames = $conn->query("SELECT DISTINCT name FROM properties WHERE type = 'Land'");
while ($row = $landNames->fetch_assoc()) $data["landNames"][] = $row["name"];

/* $prices = $conn->query("SELECT DISTINCT price_range FROM properties");
while ($row = $prices->fetch_assoc()) $data["priceRanges"][] = $row["price_range"]; */

echo json_encode($data);
$conn->close();
?>