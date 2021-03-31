public class Funkcje {

    public int[] makeTable(int size) {    //tablica na szerokosc obrazka
        int[] tab = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == size / 2) {
                tab[i] = 1;
            } else
                tab[i] = 0;
        }
        return tab;
    }

    public int[] makeTable2(int rules, int[] tab, int war) {
        String rulesbinarnie = Integer.toBinaryString(rules);  //rules na binarny
        int[] tabHelper = new int[tab.length];
        int left=0;
        int right=0;

        for (int i = 0; i < tab.length; i++) {

            left=i-1;
            right=i+1;

            if (i == 0) {
                if (war == 0) {     //warunki periodyczne (1) rrruuulonik
                    left = tab.length - 1;
                    right = i + 1;
                }
                else {        //jedynki na brzegach
                    left=i-1;
                    right=i+1;
                    try {
                        if (tab[i] == 0 && tab[right] == 0) {  //zakladam ze lewy jest czarny
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 5)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;

                        } else if (tab[i] == 0 && tab[right] == 1) {
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 6)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;

                        } else if (tab[i] == 1 && tab[right] == 0) {
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 7)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;

                        } else if (tab[i] == 1 && tab[right] == 1) {
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 8)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;
                        }
                    } catch (Exception e){
                        tabHelper[i]=0;
                    }
                }
            }
            if (i == tab.length - 1) {  //last
                if(war==0){    //periodyczne
                    left = i - 1;
                    right = tab[0];
                }
                else{
                    //na koncu zakladamy ze z prawej strony jest 1
                    left=i-1;
                    right=i+1;
                    try{
                        if (tab[left] == 0 && tab[i] == 0) {
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 2)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;

                        } else if (tab[left] == 0 && tab[i] == 1 ) {
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 4)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;

                        } else if (tab[left] == 1 && tab[i] == 0 ) {
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 6)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;

                        } else if (tab[left] == 1 && tab[i] == 1 ) {
                            if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 8)) == 0)
                                tabHelper[i] = 0;
                            else
                                tabHelper[i] = 1;
                        }
                    } catch (Exception e){
                        tabHelper[i]=0;
                    }
                }
            }
            try{
            if (tab[left] == 0 && tab[i] == 0 && tab[right] == 0) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 1)) == 0)  //8 miejsce
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;

            } else if (tab[left] == 0 && tab[i] == 0 && tab[right] == 1) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 2)) == 0)  //7 miejsce
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;

            } else if (tab[left] == 0 && tab[i] == 1 && tab[right] == 0) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 3)) == 0)
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;

            } else if (tab[left] == 0 && tab[i] == 1 && tab[right] == 1) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 4)) == 0)
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;

            } else if (tab[left] == 1 && tab[i] == 0 && tab[right] == 0) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 5)) == 0)
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;

            } else if (tab[left] == 1 && tab[i] == 0 && tab[right] == 1) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 6)) == 0)
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;

            } else if (tab[left] == 1 && tab[i] == 1 && tab[right] == 0) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 7)) == 0)
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;

            } else if (tab[left] == 1 && tab[i] == 1 && tab[right] == 1) {
                if (Character.getNumericValue(rulesbinarnie.charAt(rulesbinarnie.length() - 8)) == 0)
                    tabHelper[i] = 0;
                else
                    tabHelper[i] = 1;
            }
            } catch (Exception e){
                tabHelper[i]=0;
            }
        }
        return tabHelper;
    }


}
