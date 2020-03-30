
$(function(){
	$("#main").width("1000px");
	$("#data").width("1000px");
	
	});
function goPage(pno){
    var itable = document.getElementById("data");
    var num = itable.rows.length;//表格所有行数(所有记录数)
    console.log(num);
    var totalPage = 0;//总页数
    var pageSize = 13;//每页显示行数
    //总共分几页
    if(num/pageSize > parseInt(num/pageSize)){
        totalPage=parseInt(num/pageSize)+1;
    }else{
        totalPage=parseInt(num/pageSize);
    }
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  1
    var endRow = currentPage * pageSize;//结束显示的行   13
    endRow = (endRow > num)? num : endRow;    
    console.log(endRow);
    //遍历显示数据实现分页
    for(var i=1;i<(num+1);i++){
        var irow = itable.rows[i-1];
        if(i>=startRow && i<=endRow){
            irow.style.display = "table-row";
        }else{
            irow.style.display = "none";
        }
    }
    var pageEnd = document.getElementById("pageEnd");
    var tempStr = "<span>共"+totalPage+"页  </span>";
 
    if(currentPage>1){
        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"goPage("+(1)+")\">首页  </span> ";
        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"goPage("+(currentPage-1)+")\">上一页  </span>"
    }else{
        tempStr += "<span class='btn btn-default'>首页  </span> ";
        tempStr += "<span class='btn btn-default'>上一页  </span> ";
    }
 
    for(var pageIndex= 1;pageIndex<totalPage+1;pageIndex++){
        tempStr += "<a onclick=\"goPage("+pageIndex+")\"><span class='btn btn-default'>"+ pageIndex +"</span></a> ";
    }
 
    if(currentPage<totalPage){
        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"goPage("+(currentPage+1)+")\">下一页     </span>";
        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"goPage("+(totalPage)+")\"> 尾页</span>";
    }else{
        tempStr += "<span class='btn btn-default'>下一页    </span>";
        tempStr += "<span class='btn btn-default'>  尾页 </span>";
    }
 
    document.getElementById("barcon").innerHTML = tempStr;
 
};
