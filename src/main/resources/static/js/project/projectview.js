$().ready(function () {
    // 삭제버튼 모달 로직 구현, onclick="location.href='/project/delete/${project.prjId}'"
    $("#btn-delete").on("click", function() {
        // Save the teammate ID in data attribute
        $("#delete-alert-modal").data('projectId', $(this).val());
        $(".modal-text").text("프로젝트를 삭제하시겠습니까?");
        $("#delete-alert-modal").show();
    });

    $("#modal-delete-button").click(function() {
        var deleteProjectId = $("#delete-alert-modal").data('projectId');

        location.href = '/project/delete/' + deleteProjectId;

        $("#delete-alert-modal").hide();
    });

    $("#modal-cancel-button").click(function() {
        $("#delete-alert-modal").hide();
    });

    var params = new URLSearchParams(window.location.search);
    var projectId = params.get("prjId");

    var issueChartDataKeyList = []
    var issueChartDataValueList = []

    var requirementChartDataKeyList = []
    var requirementChartDataValueList = []

    var requireAllCount = 0;
    var issueAllCount = 0;

    $.get("/ajax/project/status/" + projectId, function (response) {
        var chartData = response.data.chartData;

        // Issue 데이터 처리
        chartData.issue.forEach(function (issue) {
            issueChartDataKeyList.push(issue.cmcdName);
            issueChartDataValueList.push(issue.cmcdIdCount);
            issueAllCount += issue.cmcdIdCount;
        });

        // Requirement 데이터 처리
        chartData.requirement.forEach(function (requirement) {
            requirementChartDataKeyList.push(requirement.cmcdName);
            requirementChartDataValueList.push(requirement.cmcdIdCount);
            requireAllCount += requirement.cmcdIdCount;
        });

        var requirementChart = $("#requirement-chart").get(0).getContext('2d');
        var issueChart = $("#issue-chart").get(0).getContext('2d');

        new Chart(requirementChart, {
            type: 'doughnut',
            data: {
                labels: requirementChartDataKeyList,
                datasets: [{
                    data: requirementChartDataValueList,
                    backgroundColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(153, 102, 255, 0.2)'
                    ]
                }]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: '요구사항 현황'
                    }
                }
            },
        });

        new Chart(issueChart, {
            type: 'doughnut',
            data: {
                labels: issueChartDataKeyList,
                datasets: [{
                    data: issueChartDataValueList,
                    backgroundColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(153, 102, 255, 0.2)'
                    ]
                }]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: '이슈 현황'
                    }
                }
            },
        });

        $('#requirement-info-name').append('<td>' + "전체" + '</td>');
        $('#requirement-info-value').append('<td>' + requireAllCount + '</td>');

        $('#issue-info-table-name').append('<td>' + "전체" + '</td>');
        $('#issue-info-table-value').append('<td>' + issueAllCount + '</td>');

        // info 테이블 생성
        issueChartDataKeyList.forEach(function (key) {
            $('#issue-info-table-name').append('<td>' + key + '</td>');
        });

        issueChartDataValueList.forEach(function (value) {
            $('#issue-info-table-value').append('<td>' + value + '</td>');
        });

        requirementChartDataKeyList.forEach(function (key) {
            $('#requirement-info-name').append('<td>' + key + '</td>');
        });

        requirementChartDataValueList.forEach(function (value) {
            $('#requirement-info-value').append('<td>' + value + '</td>');
        });
    });
})