$(document).ready(function () {
    // Fetch XML data
    $.ajax({
        type: "GET",
        url: "../../projectlist.xml",
        dataType: "xml",
        success: function (xml) {
            // Parse XML and populate table
            $(xml).find('projects').each(function () { // Adjusted selector to 'projects'
                var budget = $(this).find('budget').text();
                var startTime = $(this).find('startTime').text();
                var endTime = $(this).find('endTime').text();
                var customer = $(this).find('customer').find('firstName').text(); // Updated to find 'firstName' within 'customer'
                var resources = $(this).find('resources').text();
                var status = $(this).find('status').text();
                var projectID = $(this).find('projectID').text();
                var timeline = $(this).find('timeline').text();
                var type = $(this).find('type').text();

                // Append data to the table
                $('#xmlData').append('<tr>' +
                    '<td>' + projectID + '</td>' +
                    '<td>' + customer + '</td>' +
                    '<td>' + startTime + '</td>' +
                    '<td>' + endTime + '</td>' +
                    '<td>' + resources + '</td>' +
                    '<td>' + status + '</td>' +
                    '<td>' + budget + '</td>' +
                    '<td>' + timeline + '</td>' +
                    '<td>' + type + '</td>' +
                    '</tr>');
            });
        },
        error: function (xml) {
            console.log('Error loading XML file');
        }
    });
});
