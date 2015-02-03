package pl.com.agora.article.util;

public class ArticleUtil {

    private static String originalContent = "<div xmlns:fo=\\\"http://www.w3.org/1999/XSL/Format\\\" class=\\\"cmsArtykulElem\\\">\\n<p>Podczas gdy <a href=\\\"http://www.plotek.pl/plotek/0,78882,398208420.html?tag=victoria+grycan\\\" shape=\\\"rect\\\">Victoria Grycan</a> <a href=\\\"http://www.plotek.pl/plotek/1,78649,17292646,Czy_przypadkiem_nie_mialas_operacji_noska____pytaja.html\\\" shape=\\\"rect\\\">eksperymentuje z technikami makijażowymi </a>mającymi upodobnić ją do idolki, jej r&oacute;wnie rozkochana w Kim Kardashian mama kolejny raz stawia na odważne, seksowne stylizacje niczym wyjęte prosto z szafy najsłynniejszej celebrytki świata. Biust <a href=\\\"http://www.plotek.pl/plotek/0,78882,398208420.html?tag=marta+grycan\\\" shape=\\\"rect\\\">Marty Grycan</a> jest częstym bywalcem jej Instagramowych post&oacute;w, ale nie zawsze spotyka się z uznaniem bardzo wymagających internaut&oacute;w. Gorsetem, kt&oacute;ry więcej odkrywa, niż zasłania, tym razem spełniła ich oczekiwania.</p>\\n<p>\\n<img alt=\\\"Marta Grycan\\\" src=\\\"http://bi.gazeta.pl/im/88/8b/10/z17350280Q,Marta-Grycan.jpg\\\" title=\\\"Marta Grycan\\\">Instagram.com/martagrycan</p>\\n<p>Fani Grycan komplementowali jej \\\"glam\\\" stylizację na sobotni wiecz&oacute;r. Komentarz \\\"Zamieniasz się w Kim Kardashian\\\" w tym przypadku odebrany zostanie raczej pozytywnie.</p>\\n<p>\\n<img alt=\\\"Internauci o stylizacji Marty Grycan\\\" src=\\\"http://bi.gazeta.pl/im/d9/8b/10/z17350361Q,Internauci-o-stylizacji-Marty-Grycan.jpg\\\" title=\\\"Internauci o stylizacji Marty Grycan\\\"></p>\\n<p class=\\\"imgw\\\">\\n<span>Instagram.com/martagrycan</span>\\n</p>\\n<p>Zgodzicie się z tymi komentarzami? Myślicie, że Kim by się spodobało? ;)</p>\\n<p>\\n<img height=\\\"620\\\" src=\\\"http://31.media.tumblr.com/tumblr_m4nm1uIMB21rtumc4o2_250.gif\\\" width=\\\"620\\\"></p>\\n<p>\\n<em> em</em>\\n</p>\\n</div>\\n";

    public static String removeSpecialTags(String originalContent) {
        return originalContent.replaceAll("\\\\\"", "\"").replaceAll("\\\\n", "\n");
    }

}
