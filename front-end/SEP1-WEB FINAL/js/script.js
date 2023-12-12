$(document).ready(function () {
    // Fetch XML data
    $.ajax({
        type: "GET",
        url: "/projectlist.xml",
        dataType: "xml",
        success: function (xml) {
            // Parse XML and populate table
            $(xml).find('projects').each(function () { // Adjusted selector to 'projects'
                var name = $(this).find('name').text();
                var budget = $(this).find('budget').text();

                var startTime = $(this).find('startTime');
                var startDay = startTime.find('day').text();
                var startMonth = startTime.find('month').text();
                var startYear = startTime.find('year').text();
                startTime = startDay + '/' + startMonth + '/' + startYear;

                var endTime = $(this).find('endTime');
                var endDay = endTime.find('day').text();
                var endMonth = endTime.find('month').text();
                var endYear = endTime.find('year').text();
                endTime = endDay + '/' + endMonth + '/' + endYear;

                var customer = $(this).find('customer').find('firstName').text(); // Updated to find 'firstName' within 'customer'
                var manHoursUsed = $(this).find('resources').find('manHoursUsed').text();
                var expectedManHours = $(this).find('resources').find('expectedManHours').text();
                var status = $(this).find('status').text();
                var projectID = $(this).find('projectID').text();
                var timeline = $(this).find('timeline').text();
                var type = $(this).find('type').text();

                // Append data to the table
                $('#xmlData').append('<tr>' +
                    '<td>' + name + '</td>' +
                    '<td>' + projectID + '</td>' +
                    '<td>' + customer + '</td>' +
                    '<td>' + startTime + '</td>' +
                    '<td>' + endTime + '</td>' +
                    '<td>' + manHoursUsed + " / " + expectedManHours + '</td>' +
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
