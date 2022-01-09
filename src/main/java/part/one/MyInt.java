package part.one;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class MyInt implements ProInteger {
    private String number;

    public MyInt(int number) {
        this.number = String.valueOf(number);
    }

    public MyInt(String number) {
        this.number = number;
    }

    public MyInt(byte[] number) {
        this.number = new String(number, StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        while (number.startsWith("0")) {
            number = number.substring(1);
        }
        return number;
    }

    private String[] getSimplified(String a, String b) {
        String[] res = new String[4];

        res[0] = a;
        res[1] = b;
        if (res[0].startsWith("-")) {
            res[0] = res[0].substring(1);
            res[2] = "-";
        }
        if (res[1].startsWith("-")) {
            res[1] = res[1].substring(1);
            res[3] = "-";
        }

        int diff = res[0].length() - res[1].length();

        StringBuilder nolici = new StringBuilder();
        nolici.append("0".repeat(Math.abs(diff)));

        if (diff > 0) {
            res[1] = nolici + res[1];
        } else {
            res[0] = nolici + res[0];
        }

        return res;
    }


    @Override
    public ProInteger add(ProInteger i) {
        String[] normalized = getSimplified(number, i.toString());

        // Первое число отрицательное, второе положительное
        if (normalized[2] != null && normalized[3] == null) {
                return new MyInt(normalized[1]).subtract(new MyInt(normalized[0]));
        }
        // Первое число положительное, второе отрицательное
        if (normalized[2] == null && normalized[3]!=null) {
            return new MyInt(normalized[0]).subtract(new MyInt(normalized[1]));
        }

        // Оба числа отрицательны
        if (normalized[2] != null) {
            // складываем числа по модулю и добавляем "-" в начале
            return new MyInt("-" + new MyInt(normalized[0]).add(new MyInt(normalized[1])).toString());
        }


        int intermediate = 0;

        StringBuilder result = new StringBuilder();
        for (int j = normalized[0].length()-1; j >= 0 ; j--) {
            int temp =
                    (normalized[0].charAt(j) - '0') +
                    (normalized[1].charAt(j) - '0') +
                                     intermediate;
            intermediate = temp/10;
            result.append(temp%10);
        }
        if (intermediate != 0) {
            result.append(intermediate);
        }

        return new MyInt(result.reverse().toString());
    }

    @Override
    public ProInteger subtract(ProInteger i) {
        String[] normalized = getSimplified(number, i.toString());

        // Первое число отрицательное, второе положительное
        if (normalized[2] != null && normalized[3] == null) {
            return this.add(new MyInt("-"+i));
        }
        // Первое число положительное, второе отрицательное
        if (normalized[2] == null && normalized[3]!=null) {
            return new MyInt(normalized[0]).add(new MyInt(normalized[1]));
        }

        // Оба числа отрицательны
        if (normalized[2] != null) {
            // складываем числа по модулю и добавляем "-" в начале
            return new MyInt(new MyInt("-"+normalized[0]).add(new MyInt(normalized[1])).toString());
        }

        for (int ind = 0; ind < normalized[0].length(); ind++){
            int firstDig = Integer.parseInt(normalized[0].substring(ind,ind+1));
            int secondDig = Integer.parseInt(normalized[1].substring(ind,ind+1));

            if (secondDig > firstDig) {
                return new MyInt("-" + new MyInt(normalized[1]).subtract(new MyInt(normalized[0])).toString());
            } else if (secondDig == firstDig) {
                continue;
            }
            break;
        }

        int intermediate = 0;


        StringBuilder result = new StringBuilder();
        for (int j = normalized[0].length()-1; j >= 0 ; j--) {
            int temp =
                    (normalized[0].charAt(j) - '0') -
                    (normalized[1].charAt(j) - '0') -
                    intermediate;
            if (temp < 0) {
                temp+=10;
                intermediate = 1;
            } else {
                intermediate = 0;
            }

            result.append(temp);
        }

        String res = result.reverse().toString();

        if (intermediate != 0) {
            res = "-"+res;
        }
        return new MyInt(Integer.parseInt(res));
    }

    @Override
    public ProInteger multiply(ProInteger i) {
        String[] normalized = getSimplified(number, i.toString());

        ProInteger result = new MyInt("0");
        for (int x = normalized[1].length()-1; x >= 0 ; x--) {
            StringBuilder tempRes = new StringBuilder();
            int intermediate = 0;

            for (int y = normalized[0].length()-1; y >= 0 ; y--) {
                int temp =
                        (normalized[0].charAt(y) - '0') *
                                (normalized[1].charAt(x) - '0') +
                                intermediate;

                tempRes.append(temp);
            }
            result = result.add(new MyInt(tempRes.reverse()+"0".repeat(normalized[1].length()-x-1)));
        }


        if ((normalized[2] == null && normalized[3] == null) || (normalized[2].equals("-") && normalized[3].equals("-"))) {
            return result;
        }
        return new MyInt("-"+result);
    }

    @Override
    public ProInteger divide(ProInteger i) {
        String first = this.abs().toString();
        String second = i.abs().toString();
        ProInteger res = new MyInt("0");

        for (int x = first.length()-1; x >= 0 ; x--) {
            StringBuilder tempRes = new StringBuilder();
            int intermediate = 0;

            for (int y = second.length()-1; y >= 0 ; y--) {
                int temp =
                        (second.charAt(y) - '0') *
                        (first.charAt(x) - '0') +
                        intermediate;

                tempRes.append(temp);
            }
            res = res.add(new MyInt(tempRes.reverse()+"0".repeat(second.length()-x-1)));
        }

        return res;
    }

    @Override
    public ProInteger max(ProInteger i) {
        if (this.compareTo(i)) {
            return this;
        }
        return i;
    }

    @Override
    public ProInteger min(ProInteger i) {
        if (!this.compareTo(i)) {
            return this;
        }
        return i;
    }

    @Override
    public ProInteger abs() {
        return new MyInt(this.number.replace("-", ""));
    }

    /// Метод возвращает true если это число больше переданного
    @Override
    public boolean compareTo(ProInteger i) {
        String[] normalized = getSimplified(number, i.toString());

        if (Objects.equals(normalized[2], "-") && !Objects.equals(normalized[3], "-") ) {
            return false;
        }

        if (!Objects.equals(normalized[2], "-") && Objects.equals(normalized[3], "-") ) {
            return true;
        }

        for (int ind = 0; ind < normalized[0].length(); ind++){
            int firstDig = Integer.parseInt(normalized[0].substring(ind,ind+1));
            int secondDig = Integer.parseInt(normalized[1].substring(ind,ind+1));

            if (secondDig > firstDig) {
                return false;
            } else if (secondDig == firstDig) {
                continue;
            }
            return true;
        }

        return false;
    }

    @Override
    public ProInteger gcd(ProInteger i) {
        return null;
    }

    @Override
    public long longValue() {
        try {
            return Long.valueOf(this.toString()).longValue();
        } catch (NumberFormatException e) {
            String s = this.toString();
            return new MyInt(s.substring(0, s.length()-1)).longValue();
        }
    }
}
