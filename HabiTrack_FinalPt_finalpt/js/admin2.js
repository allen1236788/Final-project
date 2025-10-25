$(document).ready(function () {

  const map = L.map("map").setView([10.669644, 122.948844], 17);
  L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png").addTo(map);

  $("#addMenu, #add_house, #add_land").hide();
  let addMode = false; 
  let tempMarker = null;
  let savedMarkers = [];
  let allProperties = []; // store all fetched properties
  let removeMarkers = [];

  // --- CLICK TO ADD MARKER ---
  map.on("click", function (e) {
    if (!addMode) return;

    $("#addMenu").show();
    $(".clear").prop("disabled", false);

    if ($(e.originalEvent.target).closest("#sidebar, .leaflet-control").length > 0) return;

    $("#message").text("");
    clearInputs();

    const lat = e.latlng.lat.toFixed(6);
    const lng = e.latlng.lng.toFixed(6);

    if (tempMarker) tempMarker.setLatLng([lat, lng]);
    else {
      tempMarker = L.marker([lat, lng], { draggable: true }).addTo(map);
      tempMarker.on("dragend", function (event) {
        const pos = event.target.getLatLng();
        $("#LAT").val(pos.lat.toFixed(6));
        $("#LNG").val(pos.lng.toFixed(6));
      });
    }

    if ($("#propType").val() === "House") {
      $("#LAT").val(lat); 
      $("#LNG").val(lng);
    } else if ($("#propType").val() === "Land") {
      $("#LAT_L").val(lat);
      $("#LNG_L").val(lng);
    }
  });

  // --- INPUT VALIDATION ---
  function checkInputs() {
    let hasValue = false;
    $("#sidebar input[type='text'], #sidebar input[type='number'], #sidebar input[type='file']").each(function () {
      if ($(this).val().trim() !== "") {
        hasValue = true;
        return false;
      }
    });
    $(".clear").prop("disabled", !hasValue);
  }

  $(document).on("input change", "#sidebar input[type='text'], #sidebar input[type='number'], #sidebar input[type='file']", checkInputs);
  checkInputs();

  function limitDecimals(input, maxDecimals) {
    let value = input.value;
    if (value.includes('.')) {
      const [integer, decimal] = value.split('.');
      input.value = integer + '.' + decimal.slice(0, maxDecimals);
    }
  }
  $("#LAT, #LNG").on("input", function () { limitDecimals(this, 6); });

  $("#LAT, #LNG").on("input", function () {
    const lat = parseFloat($("#LAT").val());
    const lng = parseFloat($("#LNG").val());
    if (!isNaN(lat) && !isNaN(lng)) {
      if (!tempMarker) {
        tempMarker = L.marker([lat, lng], { draggable: true }).addTo(map);
        tempMarker.on("dragend", function (event) {
          const pos = event.target.getLatLng();
          $("#LAT").val(pos.lat.toFixed(6));
          $("#LNG").val(pos.lng.toFixed(6));
        });
      } else tempMarker.setLatLng([lat, lng]);
      map.setView([lat, lng], 17);
    }
  });

  // --- SAVE PROPERTY ---
  $("#saveHouse, #saveLand").on("click", function () {
    const isHouse = this.id === "saveHouse";
    const formData = new FormData();
    let requiredFields = isHouse
      ? ["#LAT", "#LNG", "#NAME", "#LOCATION", "#PRICE", "#PRICE_RANGE", "#LOT"]
      : ["#LAT_L", "#LNG_L", "#NAME_L", "#LOCATION_L", "#PRICE_L", "#PRICE_RANGE_L", "#LOT_L", "#SIZE"];

    for (let selector of requiredFields) {
      const el = $(selector);
      if (el.length && (el.val() === "" || el.val() === null)) {
        alert("Please fill all required fields.");
        return;
      }
    }

    if (isHouse) {
      formData.append("lat", $("#LAT").val());
      formData.append("lng", $("#LNG").val());
      formData.append("name", $("#NAME").val());
      formData.append("location", $("#LOCATION").val());
      formData.append("price", $("#PRICE").val());
      formData.append("price_range", $("#PRICE_RANGE").val());
      formData.append("storey", $("#STOREY").val());
      formData.append("bedroom", $("#BEDROOM").val());
      formData.append("tandb", $("#TANDB").val());
      formData.append("floor", $("#FLOOR").val());
      formData.append("lot", $("#LOT").val());
      const file = $("#IMAGE")[0].files[0];
      if (file) formData.append("image", file);
      formData.append("propType", "House");
    } else {
      formData.append("lat", $("#LAT_L").val());
      formData.append("lng", $("#LNG_L").val());
      formData.append("name", $("#NAME_L").val());
      formData.append("location", $("#LOCATION_L").val());
      formData.append("price", $("#PRICE_L").val());
      formData.append("price_range", $("#PRICE_RANGE_L").val());
      formData.append("lot", $("#LOT_L").val());
      formData.append("size_range", $("#SIZE").val());
      const file = $("#IMAGE_L")[0].files[0];
      if (file) formData.append("image", file);
      formData.append("propType", "Land");
    }

    $.ajax({
      url: "forms/add_property.php",
      type: "POST",
      data: formData,
      contentType: false,
      processData: false,
      success: function (response) {
        if (response.includes("<script")) { 
          const temp = $(response).appendTo("body"); 
          setTimeout(() => temp.remove(), 1000); 
        } else { 
          $("#message").css("color", "green").text(response); 
        } 
        clearInputs();
        if (tempMarker) { map.removeLayer(tempMarker); tempMarker = null; }
        fetchProperties(); // refresh property markers
      },
    });
  });

  // --- CLEAR BUTTONS ---
  $(".clear").on("click", function () {
    clearAllEPT();
    checkInputs();
    $(".clear").prop("disabled", true);
  });

  function clearInputs() {
    $("#sidebar").find("input, select").not("#propType").val("");
    $("#IMAGE, #IMAGE_L").val("");
  }

  function clearAllEPT() {
    clearInputs();
    if (tempMarker) { map.removeLayer(tempMarker); tempMarker = null; }
    $("#message").text("");
  }

  function clearAll() {
    $("#sidebar").find("input, select").val("");
    $("#IMAGE").val("");
    if (tempMarker) { map.removeLayer(tempMarker); tempMarker = null; }
    $("#message").text("");
  }

  // --- FETCH & STORE ALL PROPERTIES ---
  function fetchProperties() {
    $.getJSON("forms/fetch_properties.php", function (data) {
      allProperties = data; // store all for filtering
      displayMarkers($("#propType").val()); // show only selected type
    });
  }

  // --- DISPLAY MARKERS BY TYPE ONLY ---
  function displayMarkers(selectedType) {
    savedMarkers.forEach(m => map.removeLayer(m));
    savedMarkers = [];

    if (!selectedType) return;

    const filtered = allProperties.filter(p => p.type === selectedType);
    filtered.forEach(p => {
      const m = L.marker([p.lat, p.lng]).addTo(map)
        .bindPopup(`<b>${p.name}</b><br>${p.location}<br>₱${p.price}`);
      savedMarkers.push(m);
    });

    if (savedMarkers.length > 0) {
      const group = L.featureGroup(savedMarkers);
      map.fitBounds(group.getBounds(), { padding: [50, 50] });
    }
  }

  // --- MENU SWITCHING ---
  $("#showAddMenu").on("click", function () {
    $("#addMenu").show();
    $("#removeMenu, #add_house, #add_land").hide();
    $("#message").text("");
  });

  $("#propType").on("change", function () {
    const selected = $(this).val();
    $("#add_house, #add_land").hide();
    clearAllEPT();
    addMode = true;
    if (selected === "House") $("#add_house").fadeIn(300);
    if (selected === "Land") $("#add_land").fadeIn(300);

    displayMarkers(selected); // update map markers based on selection
  });

  $("#showRemoveMenu").on("click", function () {
    clearAll();
    addMode = false;
    $("#addMenu, #add_house, #add_land").hide();
    $("#removeMenu").show();
    $("#message").text("");
    loadPropertyList();
  });

  // --- Load properties for deletion (with markers) ---
  function loadPropertyList() {
    const type = $("#removeType").val();
    if (!type) return;

    removeMarkers.forEach(m => map.removeLayer(m));
    removeMarkers = [];

    $.getJSON(`forms/fetch_properties.php?type=${type}`, function (data) {
      const dropdown = $("#propertyList").empty();
      if (!data || data.length === 0) {
        dropdown.append('<option value="">No properties found</option>');
        return;
      }

      dropdown.append('<option value="" disabled selected>Select Property to Remove</option>');
      data.forEach(p => {
        const price = p.price ? `₱${parseFloat(p.price).toLocaleString()}` : "No Price";
        dropdown.append(`<option value="${p.id}">${p.name} — ${p.location} — ${price}</option>`);

        if (p.lat && p.lng) {
          const marker = L.marker([p.lat, p.lng], { id: p.id }).addTo(map)
            .bindPopup(`<b>${p.name}</b><br>${p.location}<br>${price}`);
          removeMarkers.push(marker);
        }
      });

      if (removeMarkers.length > 0) {
        const group = L.featureGroup(removeMarkers);
        map.fitBounds(group.getBounds(), { padding: [50, 50] });
      }
    }).fail(() => { alert("Failed to load properties. Check PHP or DB connection."); });
  }

  $("#removeType").on("change", loadPropertyList);

  $("#propertyList").on("change", function () {
    const selectedId = $(this).val();
    $("#message").text("");
    if (!selectedId) return;
    const marker = removeMarkers.find(m => m.options.id == selectedId);
    if (marker) {
      map.setView(marker.getLatLng(), 18);
      marker.openPopup();
    }
  });

  $("#deleteProperty").on("click", function () {
    const id = $("#propertyList").val();
    const type = $("#removeType").val();
    if (!id) { alert("Please select a property to delete."); return; }
    if (!confirm("Are you sure you want to delete this property?")) return;

    $.ajax({
      url: "forms/delete_property.php",
      type: "POST",
      data: { id: id, type: type },
      success: function (response) {
        $("#message").css("color", "green").text(response);
        loadPropertyList();
        fetchProperties();
      },
      error: function (xhr, status, error) {
        $("#message").css("color", "red").text("Error: " + error);
      }
    });
  });

  $("#back").on("click", function () { window.location.href = "Index.html"; });

  fetchProperties();

  setTimeout(function () { alert("Welcome Admin!"); }, 500);

});
