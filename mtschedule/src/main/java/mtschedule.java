import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class mtschedule {

    public static void main(String[] args) throws IOException {

        String url = null;

        //대구 오페라 하우스
        for(int i=7;i<=12;i++){

            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(i+"월 자료");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


            if(i<9) {
               url  = "http://www.daeguoperahouse.org/contents/01_performance/page.html?mid=026027&search_month=2020-0"+i;
            }else{
                url  = "http://www.daeguoperahouse.org/contents/01_performance/page.html?mid=026027&search_month=2020-"+i;
            }

            Document document = Jsoup.connect(url).get();

            Elements eles = document.select("div.conts");

            for(Element ele : eles){
                System.out.println("##############################");
                String title = ele.select("em").html();
                String time = ele.select("dd").first().html();

                System.out.println("제목 : "+title.replaceAll("<","").replaceAll(">",""));
                System.out.println("시작일 : "+time.replaceAll(" ","").split("~")[0]);
                System.out.println("종료일 : "+time.replaceAll(" ","").split("~")[1]);

            }



        }



    }
}
