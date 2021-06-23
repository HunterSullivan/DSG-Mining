import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Mining implements ActionListener{

    JLabel label;
    JButton mineGenerator;
    JButton gemValue;

    JFrame frame;
    JPanel panel;
    JComboBox gemType;

    public Mining() {
        frame = new JFrame();

        mineGenerator = new JButton("Generate Mine");
        mineGenerator.addActionListener(this);

        gemValue = new JButton("Get Gem Value");
        gemValue.addActionListener(this);

        label = new JLabel("Click Generate Mine to create a new mine, or choose a gem type and click Get Gem Value to get the weekly gem value");

        String[] gemTypes = {"Bloodstone", "Onyx", "Turquoise", "Agate", "Aquamarine", "Garnet", "Jade", "Alexandrite", "Amethyst", "Topaz", "Jet", "Opal", "Ruby", "Sapphire", "Diamond", "Emerald"};
        gemType = new JComboBox(gemTypes);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(gemType);
        panel.add(mineGenerator);
        panel.add(gemValue);

        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Mining");
        frame.pack();
        frame.setVisible(true);
    }

    public static String mineTime(int weeks, int months, int years) {
        Random d100 = new Random();
        String result;
        int weekRoll = d100.nextInt(100) + 1;
        if (weekRoll == 11 || weekRoll == 22 ||weekRoll == 33 ||weekRoll == 44 ||weekRoll == 55 ||weekRoll == 66 ||weekRoll == 77 ||weekRoll == 88 ||weekRoll == 99 ||weekRoll == 100) {
            weeks = weekRoll;
            int monthRoll = d100.nextInt(100) + 1;
            if (monthRoll == 11 || monthRoll == 22 ||monthRoll == 33 ||monthRoll == 44 ||monthRoll == 55 ||monthRoll == 66 ||monthRoll == 77 ||monthRoll == 88 ||monthRoll == 99 ||monthRoll == 100) {
                months = monthRoll;
                int yearRoll = d100.nextInt(100) + 1;
                years = yearRoll;
                while (yearRoll == 11 || yearRoll == 22 ||yearRoll == 33 ||yearRoll == 44 ||yearRoll == 55 ||yearRoll == 66 ||yearRoll == 77 ||yearRoll == 88 ||yearRoll == 99 ||yearRoll == 100) {
                    yearRoll = d100.nextInt(100) + 1;
                    years = years + yearRoll;
                }
                result = years + " years, " + months + " months, " + weeks + " weeks";
                return result;
            } else {
                months = monthRoll;
                result = months + " months, " + weeks + " weeks";
                return result;
            }
        } else {
            weeks = weekRoll;
            result = weeks + " weeks";
            return result;
        }
    }

    public static String product() {
        Random d100 = new Random();
        String result;
        int ore = d100.nextInt(100) + 1;
        if (ore <= 30) {
            result = "Copper";
        } else if (ore >= 31 && ore <= 40) {
            result = "Tin";
        } else if (ore >= 41 && ore <= 66) {
            result = "Lead";
        } else if (ore >= 67 && ore <= 84) {
            result = "Iron";
        } else if (ore >= 85 && ore <= 92) {
            result = "Silver";
        } else if (ore >= 93 && ore <= 97) {
            result = "Gold";
        } else if (ore == 98) {
            result = "Platinum";
        } else if (ore == 99) {
            int platCheck = d100.nextInt(10) + 1;
            if (platCheck <= 5) {
                result = "Pure Silver";
            } else if (platCheck >= 6 && platCheck <= 8) {
                result = "Pure Gold";
            } else if (platCheck == 9) {
                result = "Pure Platinum";
            } else {
                result = "Mithril";
            }
        } else {
            result = gemProduct();
        }
        return result;
    }

    public static String gemProduct() {
        Random d100 = new Random();
        String result = "";
        int ore = d100.nextInt(100) + 1;
        if (ore <= 8) {
            result = "Bloodstone";
        } else if (ore >= 9 && ore <= 18) {
            result = "Onyx";
        } else if (ore >= 19 && ore <= 24) {
            result = "Turquoise";
        } else if (ore >= 25 && ore <= 30) {
            result = "Agate";
        } else if (ore >= 31 && ore <= 36) {
            result = "Aquamarine";
        } else if (ore >= 37 && ore <= 42) {
            result = "Garnet";
        } else if (ore >= 43 && ore <= 48) {
            result = "Jade";
        } else if (ore >= 49 && ore <= 54) {
            result = "Alexandrite";
        } else if (ore >= 55 && ore <= 60) {
            result = "Amethyst";
        } else if (ore >= 61 && ore <= 66) {
            result = "Topaz";
        } else if (ore >= 67 && ore <= 72) {
            result = "Jet";
        } else if (ore >= 73 && ore <= 77) {
            result = "Opal";
        } else if (ore >= 78 && ore <= 82) {
            result = "Ruby";
        } else if (ore >= 83 && ore <= 87) {
            result = "Sapphire";
        } else if (ore >= 88 && ore <= 92) {
            result = "Diamond";
        } else if (ore >= 93 && ore <= 96) {
            result = "Emerald";
        } else if (ore >= 97 && ore <= 99) {
            if (result.isEmpty()) {
                result = gemProduct() + ", " + gemProduct();
            } else {
                result = result + ", " + gemProduct() + ", " + gemProduct();
            }
        } else {
            if (result.isEmpty()) {
                result = gemProduct() + ", " + gemProduct() + ", " + gemProduct();
            } else {
                result = result + ", " + gemProduct() + ", " + gemProduct() + ", " + gemProduct();
            }        }
        return result;
    }

    public static String quality(String ore) {
        Random d10 = new Random();
        String result = ore;
        int qualityRoll = d10.nextInt(10) + 1;
        int quality = 0;
        int pureRoll;
        switch (ore) {
            case "Copper":
                switch (qualityRoll) {
                    case 1:
                        quality = 100;
                        break;
                    case 2:
                        quality = 200;
                        break;
                    case 3:
                        quality = 250;
                        break;
                    case 4:
                        quality = 300;
                        break;
                    case 5:
                        quality = 350;
                        break;
                    case 6:
                        quality = 400;
                        break;
                    case 7:
                        quality = 500;
                        break;
                    case 8:
                        quality = 750;
                        break;
                    case 9:
                        quality = 1000;
                        break;
                    case 10:
                        quality = 2000;
                        pureRoll = d10.nextInt(10) + 1;
                        if (pureRoll == 10) {
                            result = "Pure " + ore;
                        }
                        break;
                }
                break;
            case "Tin":
                switch (qualityRoll) {
                    case 1:
                        quality = 100;
                        break;
                    case 2:
                        quality = 200;
                        break;
                    case 3:
                        quality = 250;
                        break;
                    case 4:
                        quality = 300;
                        break;
                    case 5:
                        quality = 350;
                        break;
                    case 6:
                        quality = 400;
                        break;
                    case 7:
                        quality = 500;
                        break;
                    case 8:
                        quality = 750;
                        break;
                    case 9:
                        quality = 1000;
                        break;
                    case 10:
                        quality = 2000;
                        pureRoll = d10.nextInt(10) + 1;
                        if (pureRoll == 10) {
                            result = "Pure " + ore;
                        }
                        break;
                }
                break;
            case "Lead":
                switch (qualityRoll) {
                    case 1:
                        quality = 100;
                        break;
                    case 2:
                        quality = 200;
                        break;
                    case 3:
                        quality = 250;
                        break;
                    case 4:
                        quality = 300;
                        break;
                    case 5:
                        quality = 350;
                        break;
                    case 6:
                        quality = 400;
                        break;
                    case 7:
                        quality = 500;
                        break;
                    case 8:
                        quality = 750;
                        break;
                    case 9:
                        quality = 1000;
                        break;
                    case 10:
                        quality = 2000;
                        pureRoll = d10.nextInt(10) + 1;
                        if (pureRoll == 10) {
                            result = "Pure " + ore;
                        }
                        break;
                }
                break;
            case "Iron":
                switch (qualityRoll) {
                    case 1:
                        quality = 200;
                        break;
                    case 2:
                        quality = 300;
                        break;
                    case 3:
                        quality = 500;
                        break;
                    case 4:
                        quality = 700;
                        break;
                    case 5:
                        quality = 900;
                        break;
                    case 6:
                        quality = 1200;
                        break;
                    case 7:
                        quality = 1600;
                        break;
                    case 8:
                        quality = 2000;
                        break;
                    case 9:
                        quality = 3000;
                        break;
                    case 10:
                        quality = 4000;
                        pureRoll = d10.nextInt(10) + 1;
                        if (pureRoll == 10) {
                            result = "Pure " + ore;
                        }
                        break;
                }
                break;
            case "Silver":
                switch (qualityRoll) {
                    case 1:
                        quality = 25;
                        break;
                    case 2:
                        quality = 50;
                        break;
                    case 3:
                        quality = 100;
                        break;
                    case 4:
                        quality = 200;
                        break;
                    case 5:
                        quality = 300;
                        break;
                    case 6:
                        quality = 400;
                        break;
                    case 7:
                        quality = 500;
                        break;
                    case 8:
                        quality = 750;
                        break;
                    case 9:
                        quality = 1000;
                        break;
                    case 10:
                        quality = 2000;
                        pureRoll = d10.nextInt(10) + 1;
                        if (pureRoll == 10) {
                            result = "Pure " + ore;
                        }
                        break;
                }
                break;
            case "Gold":
                switch (qualityRoll) {
                    case 1:
                        quality = 10;
                        break;
                    case 2:
                        quality = 25;
                        break;
                    case 3:
                        quality = 50;
                        break;
                    case 4:
                        quality = 100;
                        break;
                    case 5:
                        quality = 200;
                        break;
                    case 6:
                        quality = 300;
                        break;
                    case 7:
                        quality = 400;
                        break;
                    case 8:
                        quality = 500;
                        break;
                    case 9:
                        quality = 750;
                        break;
                    case 10:
                        quality = 1000;
                        pureRoll = d10.nextInt(10) + 1;
                        if (pureRoll == 10) {
                            result = "Pure " + ore;
                        }
                        break;
                }
                break;
            case "Platinum":
                switch (qualityRoll) {
                    case 1:
                        quality = 5;
                        break;
                    case 2:
                        quality = 10;
                        break;
                    case 3:
                        quality = 20;
                        break;
                    case 4:
                        quality = 40;
                        break;
                    case 5:
                        quality = 75;
                        break;
                    case 6:
                        quality = 100;
                        break;
                    case 7:
                        quality = 200;
                        break;
                    case 8:
                        quality = 400;
                        break;
                    case 9:
                        quality = 800;
                        break;
                    case 10:
                        quality = 1000;
                        pureRoll = d10.nextInt(10) + 1;
                        if (pureRoll == 10) {
                            result = "Pure " + ore;
                        }
                        break;
                }
                break;
            case "Pure Silver":
                quality = 2000;
                break;
            case "Pure Gold":
                quality = 1000;
                break;
            case "Pure Platinum":
                quality = 1000;
                break;
            case "Mithril":
                quality = 10000;
                break;
            case "Gemstone":
                quality = 999999;
                break;
        }
        return result + ", " + quality + " coins";
    }

    public static String gemVal(String gemType) {
        Random die = new Random();
        String result = "";
        int amount = 0;
        int value = 0;

        switch (gemType) {
            case "Bloodstone":
                amount = (die.nextInt(10) +1) + (die.nextInt(10) + 1);
                value = 20 + (die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1);
                break;
            case "Amber":
                amount = (die.nextInt(10) + 1);
                value = (die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1);
                break;
            case "Onyx":
                amount = (die.nextInt(10) +1) + (die.nextInt(10) + 1) + (die.nextInt(10) + 1);
                value = 10 + (die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1);
                break;
            case "Turquoise":
                amount = (die.nextInt(10) +1) + (die.nextInt(10) + 1) + (die.nextInt(10) + 1) + (die.nextInt(10) + 1);
                value = (die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1);
                break;
            case "Agate":
                amount = (die.nextInt(10) +1) + (die.nextInt(10) + 1) + (die.nextInt(10) + 1) + (die.nextInt(10) + 1);
                value = (die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1);
                break;
            case "Aquamarine":
                amount = (die.nextInt(10) +1);
                value = ((die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1)) * 10;
                break;
            case "Garnet":
                amount = (die.nextInt(10) +1);
                value = (die.nextInt(4) +1) * 100;
                break;
            case "Jade":
                amount = (die.nextInt(10) +1) + (die.nextInt(10) +1);
                value = ((die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1)) * 10;
                break;
            case "Alexandrite":
                amount = (die.nextInt(10) +1);
                value = (die.nextInt(4) +1) * 100;
                break;
            case "Amethyst":
                amount = (die.nextInt(10) +1);
                value = (die.nextInt(6) +1) * 100;
                break;
            case "Topaz":
                amount = (die.nextInt(10) +1) + (die.nextInt(10) +1);
                value = (die.nextInt(4) +1) * 100;
                break;
            case "Jet":
                amount = (die.nextInt(10) +1);
                value = ((die.nextInt(6) +1) + (die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1) +(die.nextInt(6) +1)) * 10;
                break;
            case "Opal":
                amount = (int) Math.ceil((die.nextInt(10) +1) / 3.0);
                value = (die.nextInt(6) +1) * 200;
                break;
            case "Ruby":
                amount = (int) Math.ceil((die.nextInt(10) +1) / 3.0);
                value = (die.nextInt(8) +1) * 200;
                break;
            case "Sapphire":
                amount = (int) Math.ceil((die.nextInt(10) +1) / 4.0);
                value = (die.nextInt(8) +1) * 200;
                break;
            case "Diamond":
                amount = (int) Math.ceil((die.nextInt(10) +1) / 5.0);
                value = (die.nextInt(6) +1) * 300;
                break;
            case "Emerald":
                amount = (int) Math.ceil((die.nextInt(10) +1) / 5.0);
                value = (die.nextInt(8) +1) * 300;
                break;
        }
        int exceptional = die.nextInt(100) + 1;
        if (exceptional == 100) {
            int godGem = (die.nextInt(100) + 1) * value;
            result = amount + " per Man-Week. " + value + " gp eac. Exceptional gem worth " + godGem + " gp found!";
            return result;
        } else {
            result = amount + " per Man-Week. " + value + " gp each";
            return result;
        }
    }

    public static void main(String[] args) {
//        int weeks = 0;
//        int months = 0;
//        int years = 0;
//        System.out.println(mineTime(weeks, months, years));
//        System.out.println(quality(product()));
        new Mining();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mineGenerator) {
            JOptionPane.showMessageDialog(null, "<html>" + mineTime(0, 0, 0) + "<br/>" + quality(product()) + "</html>");
        } else if (e.getSource() == gemValue) {
            JOptionPane.showMessageDialog(null, gemVal((String) gemType.getSelectedItem()));
        }

    }
}
