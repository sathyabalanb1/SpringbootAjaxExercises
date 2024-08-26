/**
 * 
 */

 $(document).ready(function() {
    $('#seltable').change(function() {
        var selectedTable = $(this).val();
        if (selectedTable) {
            $.ajax({
                url: '/form/getTableData',
                type: 'GET',
                data: { table: selectedTable },
                success: function(data) {
                    var tableHtml = '<table class="table"><thead class="thead-dark"><tr>';
                    var firstRow = data[0];

                    // Create table headers dynamically
                    for (var key in firstRow) {
                        if (firstRow.hasOwnProperty(key)) {
                            tableHtml += '<th>' + key + '</th>';
                        }
                    }
                    tableHtml += '</tr></thead><tbody class="table-success">';

                    // Create table rows dynamically
                    for (var i = 0; i < data.length; i++) {
                        tableHtml += '<tr>';
                        for (var key in data[i]) {
                            if (data[i].hasOwnProperty(key)) {
                                tableHtml += '<td>' + data[i][key] + '</td>';
                            }
                        }
                        tableHtml += '</tr>';
                    }

                    tableHtml += '</tbody></table>';
                    $('#tableContainer').html(tableHtml);
                },
                error: function() {
                    alert('Error retrieving table data.');
                }
            });
        } else {
            $('#tableContainer').html('');
        }
    });
});
