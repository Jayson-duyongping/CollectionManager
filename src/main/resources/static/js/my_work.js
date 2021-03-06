/**
 * 工作时间线
 */
$(function () {
    var nextDataNumber = 5;
    var ajaxLoading = false;
    var docNode = $(document);

    var ulNode = $('ul.timeline');

    function initLiNodes() {
        var liNodes = ulNode.find('li'), count = liNodes.length, i, liNode, leftCount = nextDataNumber * 20;
        for (i = 0; i < count; i++) {
            liNode = $(liNodes.get(i));
            if (i % 2 !== 0) {
                liNode.addClass('alt');
            } else {
                liNode.removeClass('alt');
            }
            liNode.find('.number').text(leftCount + count - i);
        }
    }

    $('#fetchNextData').click(function () {
        var $this = $(this);
        $this.addClass('disabled').text('正在加载后二十条数据...');
        ajaxLoading = true;

        $.get('./version_data_' + nextDataNumber + '.txt', function (data) {
            ajaxLoading = false;
            ulNode.append(data);
            $this.removeClass('disabled').text('后二十条数据');
            nextDataNumber--;

            if (nextDataNumber === 0) {
                $this.hide();
            }
            initLiNodes();
        });
    });
    initLiNodes();
    docNode.scroll(function () {

        if (docNode.height() - $(window).height() - docNode.scrollTop() < 10) {
            if (!ajaxLoading) {
                $('#fetchNextData').click();
            }
        }
    });
});