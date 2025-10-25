<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "habitrack";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
  die("<script>alert('Database connection failed!');</script>"); //new from chat
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $name       = $_POST['name'];       
    $location   = $_POST['location'];   
    $price      = $_POST['price'];      
    $price_range= $_POST['price_range']; 
    $propType   = $_POST['propType'];  
    $lat        = $_POST['lat'];        
    $lng        = $_POST['lng'];        
    $lot        = $_POST['lot'];        

    $bedroom = isset($_POST['bedroom']) && $_POST['bedroom'] !== "" ? (int)$_POST['bedroom'] : 0;
    $storey  = isset($_POST['storey']) && $_POST['storey'] !== "" ? (int)$_POST['storey'] : 0;
    $tandb   = isset($_POST['tandb']) && $_POST['tandb'] !== "" ? (int)$_POST['tandb'] : 0;
    $floor   = !empty($_POST['floor']) ? $_POST['floor'] : "";
    $size_range = !empty($_POST['size']) ? $_POST['size'] : "";

    // === VALIDATION SECTION === //
    if (empty($name) || empty($location) || empty($propType)) { //new from chat
        echo "<script>alert('Please fill in all required fields: Name, Location, and Property Type.');</script>"; //new from chat
        exit; //new from chat
    } //new from chat

    if (!isset($_FILES["image"]) || $_FILES["image"]["error"] != 0) { //new from chat
        echo "<script>alert('Please upload an image before submitting.');</script>"; //new from chat
        exit; //new from chat
    } //new from chat

    // === File Upload === //
    $targetDir = "uploads/";
    if (!is_dir($targetDir)) mkdir($targetDir, 0777, true);
    $fileName = basename($_FILES["image"]["name"]);
    $targetFile = $targetDir . time() . "_" . $fileName;

    if (move_uploaded_file($_FILES["image"]["tmp_name"], $targetFile)) {
        $sql = "INSERT INTO properties 
                (name, location, price, price_range, type, bedroom, storey, tandb, lat, lng, floor, lot, size_range, image)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        $stmt = $conn->prepare($sql);
        if (!$stmt) {
            echo "<script>alert('Database prepare failed: " . addslashes($conn->error) . "');</script>"; //new from chat
            exit; //new from chat
        }

        $stmt->bind_param(
          "ssdssiiiddssss",
          $name,
          $location,
          $price,
          $price_range,
          $propType,
          $bedroom,
          $storey,
          $tandb,
          $lat,
          $lng,
          $floor,
          $lot,
          $size_range,
          $targetFile
        );

        if ($stmt->execute()) {
            echo "<script>alert('Property added successfully!');</script>"; //new from chat
        } else {
            echo "<script>alert('Error adding property: " . addslashes($stmt->error) . "');</script>"; //new from chat
        }

        $stmt->close();
    } else {
        echo "<script>alert('Failed to upload image. Please try again.');</script>"; //new from chat
    }
}

$conn->close();
?>
