import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lunhengle on 2016/8/22.
 */
public class TestDate {
    @Test
    public void testDateFormat() {
        System.out.println(String.valueOf(getBirthday(null)));
    }

    private String getBirthday(String idCardNo) {
        String birthday = null;
        if (null == idCardNo && idCardNo.length() == 0) {
            //输入的身份证号为空
        } else if (idCardNo.length() == 18) {
            birthday = idCardNo.substring(6, 14);
        } else if (idCardNo.length() == 15) {
            birthday = idCardNo.substring(6, 12);
        } else {

        }
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sf2.format(sf1.parse(idCardNo));
        } catch (ParseException e) {
            System.out.println("有错误");
            return null;
        } catch (NullPointerException e) {
            return null;
        }
        return birthday;
    }

    @Test
    public void testMonth() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR) + "_" + (calendar.get(Calendar.MONTH) + 1));
    }

    @Test
    public void getDate() throws ParseException {
        SimpleDateFormat sf1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        String str = sf2.format(dd());
        Date beginTime = sf1.parse(str + " 00:00:00.000");
        Date endTime = sf1.parse(str + " 23:59:59.000");
        System.out.println(str + "#" + beginTime + "#" + endTime);
    }

    private Date dd() {
        Calendar cal = Calendar.getInstance();
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }
    @Test
    public void testTimestamp(){
        System.out.println( new Timestamp(System.currentTimeMillis()));
    }
}
