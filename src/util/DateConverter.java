package util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateConverter {

	public Date ConvertDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {

            Date date = formatter.parse(dateString);
            return date;
           

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

}
