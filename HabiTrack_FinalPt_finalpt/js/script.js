$(document).ready(function () {
  console.log("✅ script.js is running");

  $.getJSON("forms/get_dropdowns.php", function (data) {
    console.log("Dropdown data:", data);
    console.log("houseLocation element:", $("#houseLocation").length);


    if (data.error) {
      alert(data.error);
      return;
    }

    // Clear and repopulate dropdowns
    $("#houseLocation").empty().append('<option value="" disabled selected>Location</option>');
    $("#landLocation").empty().append('<option value="" disabled selected>Location</option>');
    $("#houseName").empty().append('<option value="" disabled selected>Property Name</option>');
    $("#lotName").empty().append('<option value="" disabled selected>Property Name</option>');
    //$("#housePrice, #landPrice").empty().append('<option value="" disabled selected>Price Range</option>');

    data.houseLocations.forEach(loc => $("#houseLocation").append(`<option>${loc.trim()}</option>`));
    data.landLocations.forEach(loc => $("#landLocation").append(`<option>${loc.trim()}</option>`));
    data.houseNames.forEach(name => $("#houseName").append(`<option>${name.trim()}</option>`));
    data.landNames.forEach(name => $("#lotName").append(`<option>${name.trim()}</option>`));
    /* data.priceRanges.forEach(price => {
      if (price.trim() !== "") $("#housePrice, #landPrice").append(`<option>${price.trim()}</option>`);
    }); */
  })
  .fail(() => alert("❌ Failed to load dropdown data — check PHP or DB connection."));




  // --- Map setup ---
  let map = L.map("map").setView([10.68, 122.95], 12);
  L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", { maxZoom: 19 }).addTo(map);
  let markers = [];
  let selectedProperty = null;


  function clearMarkers() {
    markers.forEach(m => map.removeLayer(m));
    markers = [];
  }

  function searchProperties(type) {
    clearMarkers();
    let filters = { type };

    if (type === "House") {
      filters.location = $("#houseLocation").val();
      filters.storey = $("#storeySelect").val();
      filters.bedroom = $("#bedroomSelect").val();
      filters.price_range = $("#housePrice").val();
      filters.name = $("#houseName").val();
    } else if (type === "Land") {
      filters.location = $("#landLocation").val();
      filters.price_range = $("#landPrice").val();
      filters.name = $("#lotName").val();
      filters.size = $("#landSize").val();
    }

    const hasFilter = Object.values(filters).some(v => v && v !== type);
    if (!hasFilter) return alert("Please select at least one filter before searching.");

    $.getJSON("forms/fetch_properties.php", filters, function (data) {
      if (data.error) return alert(data.error);
      if (!Array.isArray(data) || data.length === 0) return alert("No matching properties found.");

      data.forEach(addMarker);
      map.setView([data[0].lat, data[0].lng], 13);
    }).fail(() => alert("Failed to fetch property data."));
  }

  $("#searchhh").click(() => searchProperties("House"));
  $("#search").click(() => searchProperties("Land"));

  // --- Show sng property details..diri start ---
function showDetails(property) {
  if (!property) return;

  const modalId = property.type === "House" ? "#houseModal" : "#landModal";
  const modal = $(modalId);

  // --- Build info layout (image on top, responsive height) ---
  let info = `
    <span class="close">&times;</span>
    <div class="image-container">
      <img src="${property.image}" alt="Property Image">
    </div>
    <div class="text-container">
      <h2 ><b>${property.name}</b></h2> 
      
    <div class="location-row">
    <img src="assets/location.png" alt="Location Image" class="location-img">
      <b> Location:</b> ${property.location}
    </div>
      <hr>

     <div class="location-row">
    <img src="assets/price.png" alt="Location Image" class="location-img">
      <b> Price:</b> ${property.price}
    </div> 
      <hr>

      <div class="location-row">
    <img src="assets/price_range.png" alt="Location Image" class="location-img">
      <b> Price Range:</b> ${property.price_range}
    </div> 
      <hr>

     
      
     `;
      

  if (property.type === "House") {
    info += `
      <div class="location-row">
    <img src="assets/house.png" alt="Location Image" class="location-img">
      <b> Type:</b> ${property.type}
    </div> 
      <hr>

      <div class="location-row">
    <img src="assets/bed.png" alt="Location Image" class="location-img">
      <b> Bedroom:</b> ${property.bedroom}
    </div> 
      <hr>

      <div class="location-row">
    <img src="assets/storey.png" alt="Location Image" class="location-img">
      <b> Storey:</b> ${property.storey}
    </div> 
      <hr>

      <div class="location-row">
    <img src="assets/toilet.png" alt="Location Image" class="location-img">
      <b> Toilet & Bath:</b> ${property.tandb}
    </div> 
      <hr>

      <div class="location-row">
    <img src="assets/floor.png" alt="Location Image" class="location-img">
      <b> Floor Area:</b> ${property.floor}
    </div> 
      <hr>

      <div class="location-row">
    <img src="assets/lot.png" alt="Location Image" class="location-img">
      <b> Lot Area:</b> ${property.lot}
    </div> 
    <hr>
   
        <div class="location-row">
      <img src="assets/price_range.png" alt="Location Image" class="location-img">
      <b> Contact:</b> 09163192914
    </div>
    <hr>
      `;
  } else if (property.type === "Land") {
    info += `
    <div class="location-row">
    <img src="assets/land.png" alt="Location Image" class="location-img">
      <b> Type:</b> ${property.type}
    </div> 
      <hr>

    <div class="location-row">
    <img src="assets/lot.png" alt="Location Image" class="location-img">
      <b> Lot size:</b> ${property.lot}
    </div> 
   <hr>

    <div class="location-row">
  <img src="assets/price_range.png" alt="Location Image" class="location-img">
  <b> Contact:</b> 09163192914
</div>
<hr>


    
   
    `;
  }

  info += `</div>`;

  modal.find(".modal-content").html(info);
  $(".modal").removeClass("active");
  modal.addClass("active");
}


  $("#detail, #detailss").click(function () {
    if (!selectedProperty){
      alert("Click a marker first!");
    return;
    } 
    showDetails(selectedProperty);
    
  });
  // --- Close Modal (X) ---
$(document).on("click", ".close", function () {
  $(this).closest(".modal").removeClass("active");
});

// --- Close Modal when clicking outside ---
$(document).on("click", ".modal", function (e) {
  if ($(e.target).is(".modal")) {
    $(this).removeClass("active");
  }
});


  $("#propertyType").change(function () {
    const selected = $(this).val();
    $("#houseSection, #landSection").hide();
    if (selected === "house") $("#houseSection").fadeIn(200);
    if (selected === "land") $("#landSection").fadeIn(200);
    $("#detail, #detailss").prop("disabled", true);
    selectedProperty = null;
  });

  //$("#admin").click(() => window.open("admin.html", "_blank"));

  $("#admin").click(() => setTimeout(() => {
          window.location.href = "admin.html";
        }, 1000));

   // === FACILITY TRACKING (Geofence with dropdown after marker click) ===
let facilityLayerGroup = L.layerGroup().addTo(map);
let lineLayerGroup = L.layerGroup().addTo(map);
let houseCircle = null;
let currentRadius = 1000; // default radius
let houseLat = null;
let houseLng = null;

// Create Leaflet dropdown control (hidden initially)
const radiusControl = L.control({ position: "topright" });

radiusControl.onAdd = function () {
  const div = L.DomUtil.create("div", "radius-control");
  div.style.display = "none"; // hide initially
  div.innerHTML = `
    <label style="font-size:13px; font-weight:bold; display:block; margin-bottom:3px; text-align:center;">
      Geofence Range
    </label>
    <select id="radiusSelect" style="width:120px; padding:4px; border-radius:5px; border:1px solid gray;">
      <option value="500">500 m</option>
      <option value="1000" selected>1 km</option>
      <option value="2000">2 km</option>
      <option value="3000">3 km</option>
    </select>
  `;
  L.DomEvent.disableClickPropagation(div);
  return div;
};

radiusControl.addTo(map);

// Wait until map is ready, then cache the control element safely
let radiusControlDiv = null;
map.whenReady(() => {
  radiusControlDiv = document.querySelector(".radius-control");
});

// Make sure clearMarkers hides control and clears facility layers
function clearMarkers() {
  markers.forEach(m => map.removeLayer(m));
  markers = [];

  // hide radius control and clear geofence/facilities when markers cleared
  if (radiusControlDiv) radiusControlDiv.style.display = "none";
  if (houseCircle) { map.removeLayer(houseCircle); houseCircle = null; }
  facilityLayerGroup.clearLayers();
  lineLayerGroup.clearLayers();
}

// Unified addMarker (replace any earlier addMarker definitions with this)
function addMarker(property) {
  const lat = parseFloat(property.lat);
  const lng = parseFloat(property.lng);
  const marker = L.marker([lat, lng]).addTo(map);
  marker.bindPopup(`<b>${property.name}</b><br>${property.location}`);

  marker.on("click", () => {
    selectedProperty = property;
    $("#detail, #detailss").prop("disabled", false);

    // Show the dropdown control (make sure element exists)
    if (!radiusControlDiv) map.whenReady(() => { radiusControlDiv = document.querySelector(".radius-control"); });
    if (radiusControlDiv) radiusControlDiv.style.display = "block";

    // set house coords for loading facilities
    houseLat = lat;
    houseLng = lng;

    // load facilities initially, using the currently selected radius
    const sel = document.getElementById("radiusSelect");
    if (sel) currentRadius = parseInt(sel.value);
    loadFacilities(houseLat, houseLng);

    // wire change handler (re-assigning is safe)
    if (sel) {
      sel.onchange = function () {
        currentRadius = parseInt(this.value);
        loadFacilities(houseLat, houseLng);
      };
    }
  });

  markers.push(marker);
}

// Facility loader (cleans previous circle/lines first)
function loadFacilities(hLat, hLng) {
  $.getJSON("forms/get_facilities.php", function (facilities) {
    // clear previous facility markers and lines
    facilityLayerGroup.clearLayers();
    lineLayerGroup.clearLayers();

    // remove previous circle
    if (houseCircle) { map.removeLayer(houseCircle); houseCircle = null; }

    // draw new circle
    houseCircle = L.circle([hLat, hLng], {
      radius: currentRadius,
      color: "blue",
      fillColor: "lightblue",
      fillOpacity: 0.15
    }).addTo(map);

    // icon and color maps
    const icons = {
      church: L.icon({ iconUrl: "assets/church.png", iconSize: [50,50], iconAnchor:[25,48], popupAnchor:[0,-25]}),
      hospital: L.icon({ iconUrl: "assets/hospital.png", iconSize: [50,50], iconAnchor:[25,48], popupAnchor:[0,-25]}),
      school: L.icon({ iconUrl: "assets/school.png", iconSize: [50,50], iconAnchor:[25,48], popupAnchor:[0,-25]}),
      default: L.icon({ iconUrl: "assets/default.png", iconSize:[50,50], iconAnchor:[12,25], popupAnchor:[0,-20]})
    };

    const colorMap = {
      "church":"purple","hospital":"red","school":"blue","supermarket":"green","mall":"pink",
      "wet market":"brown","fast food chains":"orange","fastfood":"orange","fast food":"orange",
      "gasoline stations":"gold","gas station":"gold","gasoline station":"gold"
    };

    // plot facilities inside radius
    facilities.forEach(facility => {
      const fLat = parseFloat(facility.lat);
      const fLng = parseFloat(facility.lng);
      const distance = map.distance([hLat, hLng], [fLat, fLng]);

      if (distance <= currentRadius) {
        const categoryKey = facility.category?.toString().trim().toLowerCase();
        const icon = icons[categoryKey] || icons.default;
        const color = colorMap[categoryKey] || "gray";

        L.marker([fLat, fLng], { icon })
          .bindPopup(`<b>${facility.name}</b><br>Category: ${facility.category}<br>Distance: ${(distance/1000).toFixed(2)} km`)
          .addTo(facilityLayerGroup);

        L.polyline([[hLat, hLng], [fLat, fLng]], { color: color, weight: 2, opacity: 0.8 })
          .addTo(lineLayerGroup);
      }
    });
  }).fail(() => console.error("❌ Failed to load facilities."));
}


  /* $("#clearButton").on("click", function () {
    
    $(".clear").prop("disabled", true);
  }); */

  // Add this inside your $(document).ready(...)
/* $("#clearButton").on("click", function () {
    // Reset all dropdowns
    $("#propertyType").val("").change(); // resets main property type dropdown and triggers change
    $("#houseLocation, #landLocation, #houseName, #lotName, #storeySelect, #bedroomSelect, #housePrice, #tandb, #landPrice, #landSize").val("");
    
    // Optionally hide the house/land sections
    $("#houseSection, #landSection").hide();

    // Disable detail buttons
    $("#detail, #detailss").prop("disabled", true);

    // Clear selected property
    selectedProperty = null;
}); */


$("#clearButton").on("click", function () {
    // Reset dropdowns to their default option (the first option)
    $("#propertyType").val("").change(); // triggers change to hide sections

    $("#houseLocation").prop('selectedIndex', 0);
    $("#landLocation").prop('selectedIndex', 0);
    $("#houseName").prop('selectedIndex', 0);
    $("#lotName").prop('selectedIndex', 0);
    $("#storeySelect").prop('selectedIndex', 0);
    $("#bedroomSelect").prop('selectedIndex', 0);
    $("#housePrice").prop('selectedIndex', 0);
    $("#tandb").prop('selectedIndex', 0);
    $("#landPrice").prop('selectedIndex', 0);
    $("#landSize").prop('selectedIndex', 0);

    // Hide sections
    $("#houseSection, #landSection").hide();

    // Disable detail buttons
    $("#detail, #detailss").prop("disabled", true);

    // Clear selected property
    selectedProperty = null;
       clearMarkers();

       // 🧭 Hide the Geofence dropdown control
  const radiusDiv = document.querySelector(".radius-control");
  radiusDiv.hide();

});




});
