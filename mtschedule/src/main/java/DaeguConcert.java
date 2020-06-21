import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DaeguConcert {

    public static void main(String[] args) {

        String url="https://concerthouse.daegu.go.kr/front/concert.do?MENU_IDX=8&SUB_IDX=32";
        try {
            Document document = Jsoup.connect(url).get();

            Elements eles = document.select("ul.con_list_box_ul li");

            for(Element ele : eles){
                System.out.println("##############################");
                String title = ele.select("p.title").html();
                String[] Date = ele.select("p.date").html().split("-");
                String time = ele.select("span.listTime").html();


                System.out.println("제목 : "+title.replaceAll("<","").replaceAll(">",""));

                System.out.println("시작일 : "+ Date[0]+"-"+Date[1]+"-"+Date[2].split(" ")[0]);
                System.out.println("시작시간 : "+time);



            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
