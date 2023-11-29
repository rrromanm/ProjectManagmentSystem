$(document).ready(function () {
    // Fetch XML data
    $.ajax({
        type: "GET",
        url: "xml/projects.xml",
        dataType: "xml",
        success: function (xml) {
            // Parse XML and populate table
            $(xml).find('project').each(function () {
                var budget = $(this).find('budget').text();
                var startTime = $(this).find('start-time').text();
                var endTime = $(this).find('end-time').text();
                var customer = $(this).find('customer').text();
                var resources = $(this).find('resources').text();
                var status = $(this).find('status').text();
                var projectID = $(this).find('projectID').text();
                var timeline = $(this).find('timeline').text();
                var type = $(this).find('type').text();

                // Append data to the table
                $('#xmlData').append('<tr>' +
                    '<td>' + budget + '</td>' +
                    '<td>' + startTime + '</td>' +
                    '<td>' + endTime + '</td>' +
                    '<td>' + customer + '</td>' +
                    '<td>' + resources + '</td>' +
                    '<td>' + status + '</td>' +
                    '<td>' + projectID + '</td>' +
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
