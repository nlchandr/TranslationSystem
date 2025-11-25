package models;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocaleFormatter {

    public String formatCurrency(double amount, String localeCode) {
        Locale locale = toLocale(localeCode);
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(amount);
    }

    public String formatDate(LocalDate date, String localeCode) {
        Locale locale = toLocale(localeCode);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", locale);
        return date.format(formatter);
    }

    private Locale toLocale(String localeCode) {
        if (localeCode == null || localeCode.isEmpty()) {
            return Locale.ENGLISH;
        }
        String[] parts = localeCode.split("_");
        if (parts.length == 1) {
            return new Locale(parts[0]);
        } else {
            return new Locale(parts[0], parts[1]);
        }
    }
}
