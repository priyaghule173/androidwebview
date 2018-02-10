package felix.kawasakiapplication.util;

/**
 * Created by varsovski on 28-Sep-15.
 */
public class Constants {

    public static final int SPLASH_DELAY = 5000;
    public static final String EMPTY = "";

    //fonts
    public static final String STREATWEAR_FONT = "fonts/streatwear.otf";
    public static final String DITI_SWEET_FONT = "fonts/diti_sweet.ttf";
    public static final String GERMANIA_ONE_FONT = "fonts/germania_one.ttf";
    public static final String SLIMJIM_FONT = "fonts/slimjim.ttf";
    public static final String VOLATIRE_FONT = "fonts/volatire.ttf";

    public static final String[] FONTS = {EMPTY, STREATWEAR_FONT, DITI_SWEET_FONT, GERMANIA_ONE_FONT, SLIMJIM_FONT, VOLATIRE_FONT};

    //flags
    public static final String FOR_WHAT = "forWhat";
    public static final int FOR_LOGO = 0;
    public static final int FOR_TEXT = 1;
    public static final String CONFIG = "config";

    //path
    /*public static final String DROID_LOGO = "M 149.22,22.00\n" +
            "           C 148.23,20.07 146.01,16.51 146.73,14.32\n" +
            "             148.08,10.21 152.36,14.11 153.65,16.06\n" +
            "             153.65,16.06 165.00,37.00 165.00,37.00\n" +
            "             194.29,27.24 210.71,27.24 240.00,37.00\n" +
            "             240.00,37.00 251.35,16.06 251.35,16.06\n" +
            "             252.64,14.11 256.92,10.21 258.27,14.32\n" +
            "             258.99,16.51 256.77,20.08 255.78,22.00\n" +
            "             252.53,28.28 248.44,34.36 246.00,41.00\n" +
            "             252.78,43.16 258.78,48.09 263.96,52.85\n" +
            "             281.36,68.83 289.00,86.62 289.00,110.00\n" +
            "             289.00,110.00 115.00,110.00 115.00,110.00\n" +
            "             115.00,110.00 117.66,91.00 117.66,91.00\n" +
            "             120.91,76.60 130.30,62.72 141.04,52.85\n" +
            "             146.22,48.09 152.22,43.16 159.00,41.00\n" +
            "             159.00,41.00 149.22,22.00 149.22,22.00 Z\n" +
            "           M 70.80,56.00\n" +
            "           C 70.80,56.00 97.60,100.00 97.60,100.00\n" +
            "             101.34,106.21 108.32,116.34 110.21,123.00\n" +
            "             113.76,135.52 103.90,147.92 91.00,147.92\n" +
            "             78.74,147.92 74.44,139.06 69.00,130.00\n" +
            "             69.00,130.00 39.80,82.00 39.80,82.00\n" +
            "             35.73,75.29 28.40,66.08 29.20,58.00\n" +
            "             30.26,47.20 38.61,40.47 49.00,39.72\n" +
            "             61.22,40.24 64.96,46.28 70.80,56.00 Z\n" +
            "           M 375.80,58.00\n" +
            "           C 376.60,66.08 369.27,75.29 365.20,82.00\n" +
            "             365.20,82.00 336.00,130.00 336.00,130.00\n" +
            "             330.71,138.82 326.73,147.24 315.00,147.89\n" +
            "             301.74,148.63 291.14,135.87 294.79,123.00\n" +
            "             296.68,116.34 303.66,106.21 307.40,100.00\n" +
            "             307.40,100.00 333.00,58.00 333.00,58.00\n" +
            "             339.02,47.98 342.23,40.92 355.00,39.72\n" +
            "             365.83,40.00 374.69,46.77 375.80,58.00 Z\n" +
            "           M 289.00,116.00\n" +
            "           C 289.00,116.00 289.00,239.00 289.00,239.00\n" +
            "             288.98,249.72 285.92,257.31 275.00,261.10\n" +
            "             265.22,264.50 258.37,259.56 255.02,264.43\n" +
            "             253.78,266.24 254.00,269.84 254.00,272.00\n" +
            "             254.00,272.00 254.00,298.00 254.00,298.00\n" +
            "             254.00,304.85 254.77,310.07 250.36,315.93\n" +
            "             242.35,326.68 226.84,326.49 218.80,315.93\n" +
            "             215.07,311.00 215.01,306.83 215.00,301.00\n" +
            "             215.00,301.00 215.00,262.00 215.00,262.00\n" +
            "             215.00,262.00 190.00,262.00 190.00,262.00\n" +
            "             190.00,262.00 190.00,301.00 190.00,301.00\n" +
            "             189.99,306.83 189.93,311.00 186.20,315.93\n" +
            "             178.16,326.49 162.65,326.68 154.64,315.93\n" +
            "             151.09,311.22 151.01,307.61 151.00,302.00\n" +
            "             151.00,302.00 151.00,272.00 151.00,272.00\n" +
            "             151.00,269.84 151.22,266.24 149.98,264.43\n" +
            "             146.53,259.42 138.97,264.76 129.00,260.86\n" +
            "             118.39,256.72 116.02,248.29 116.00,238.00\n" +
            "             116.00,238.00 116.00,116.00 116.00,116.00\n" +
            "             116.00,116.00 289.00,116.00 289.00,116.00 Z";*/

        public static final String DROID_LOGO = "M 859.00,469.09\n" +
                "           C 859.00,469.09 877.00,470.00 877.00,470.00\n" +
                "             877.00,470.00 877.00,491.00 877.00,491.00\n" +
                "             877.00,491.00 846.00,491.00 846.00,491.00\n" +
                "             846.00,491.00 846.00,470.00 846.00,470.00\n" +
                "             846.00,470.00 859.00,469.09 859.00,469.09 Z\n" +
                "           M 846.00,521.00\n" +
                "           C 846.00,517.42 845.07,504.03 847.60,502.02\n" +
                "             849.19,500.77 853.01,501.00 855.00,501.00\n" +
                "             855.00,501.00 877.00,501.00 877.00,501.00\n" +
                "             877.00,501.00 877.00,580.00 877.00,580.00\n" +
                "             877.00,580.00 846.00,580.00 846.00,580.00\n" +
                "             846.00,580.00 846.00,521.00 846.00,521.00 Z\n" +
                "           M 780.00,469.00\n" +
                "           C 780.00,469.00 781.00,520.00 781.00,520.00\n" +
                "             781.00,520.00 783.00,519.00 783.00,519.00\n" +
                "             783.00,519.00 784.00,520.00 784.00,520.00\n" +
                "             784.00,520.00 786.00,514.00 786.00,514.00\n" +
                "             786.00,514.00 800.04,500.59 800.04,500.59\n" +
                "             800.04,500.59 811.00,500.00 811.00,500.00\n" +
                "             811.00,500.00 834.00,500.00 834.00,500.00\n" +
                "             831.35,506.60 825.97,509.82 821.19,514.91\n" +
                "             821.19,514.91 815.57,521.47 815.57,521.47\n" +
                "             813.48,523.74 809.85,526.89 809.19,529.99\n" +
                "             808.55,533.04 814.96,542.14 816.84,545.00\n" +
                "             816.84,545.00 839.00,579.94 839.00,579.94\n" +
                "             839.00,579.94 814.00,579.94 814.00,579.94\n" +
                "             814.00,579.94 805.09,579.94 805.09,579.94\n" +
                "             805.09,579.94 798.88,573.00 798.88,573.00\n" +
                "             798.88,573.00 787.00,553.00 787.00,553.00\n" +
                "             778.57,558.41 780.08,560.86 780.00,570.00\n" +
                "             779.98,571.90 780.10,578.04 778.93,579.40\n" +
                "             777.55,580.99 773.11,580.33 771.00,580.37\n" +
                "             761.71,580.58 760.60,579.10 750.00,581.00\n" +
                "             750.00,581.00 749.00,553.00 749.00,553.00\n" +
                "             749.00,553.00 749.00,499.00 749.00,499.00\n" +
                "             749.00,499.00 749.00,478.00 749.00,478.00\n" +
                "             749.00,478.00 751.00,472.00 751.00,472.00\n" +
                "             751.00,472.00 750.00,470.00 750.00,470.00\n" +
                "             750.00,470.00 780.00,469.00 780.00,469.00 Z\n" +
                "           M 778.00,471.00\n" +
                "           C 778.00,471.00 779.00,472.00 779.00,472.00\n" +
                "             779.00,472.00 779.00,471.00 779.00,471.00\n" +
                "             779.00,471.00 778.00,471.00 778.00,471.00 Z\n" +
                "           M 798.00,503.00\n" +
                "           C 798.00,503.00 799.00,504.00 799.00,504.00\n" +
                "             799.00,504.00 799.00,503.00 799.00,503.00\n" +
                "             799.00,503.00 798.00,503.00 798.00,503.00 Z\n" +
                "           M 794.00,507.00\n" +
                "           C 794.00,507.00 795.00,508.00 795.00,508.00\n" +
                "             795.00,508.00 795.00,507.00 795.00,507.00\n" +
                "             795.00,507.00 794.00,507.00 794.00,507.00 Z\n" +
                "           M 821.00,512.00\n" +
                "           C 821.00,512.00 822.00,513.00 822.00,513.00\n" +
                "             822.00,513.00 822.00,512.00 822.00,512.00\n" +
                "             822.00,512.00 821.00,512.00 821.00,512.00 Z\n" +
                "           M 818.00,515.00\n" +
                "           C 818.00,515.00 819.00,516.00 819.00,516.00\n" +
                "             819.00,516.00 819.00,515.00 819.00,515.00\n" +
                "             819.00,515.00 818.00,515.00 818.00,515.00 Z\n" +
                "           M 778.00,516.00\n" +
                "           C 778.00,516.00 779.00,517.00 779.00,517.00\n" +
                "             779.00,517.00 779.00,516.00 779.00,516.00\n" +
                "             779.00,516.00 778.00,516.00 778.00,516.00 Z\n" +
                "           M 817.00,516.00\n" +
                "           C 817.00,516.00 818.00,517.00 818.00,517.00\n" +
                "             818.00,517.00 818.00,516.00 818.00,516.00\n" +
                "             818.00,516.00 817.00,516.00 817.00,516.00 Z\n" +
                "           M 787.00,518.00\n" +
                "           C 787.00,518.00 788.00,519.00 788.00,519.00\n" +
                "             788.00,519.00 788.00,518.00 788.00,518.00\n" +
                "             788.00,518.00 787.00,518.00 787.00,518.00 Z\n" +
                "           M 778.00,519.00\n" +
                "           C 778.00,519.00 779.00,520.00 779.00,520.00\n" +
                "             779.00,520.00 779.00,519.00 779.00,519.00\n" +
                "             779.00,519.00 778.00,519.00 778.00,519.00 Z\n" +
                "           M 808.00,540.00\n" +
                "           C 808.00,540.00 809.00,541.00 809.00,541.00\n" +
                "             809.00,541.00 809.00,540.00 809.00,540.00\n" +
                "             809.00,540.00 808.00,540.00 808.00,540.00 Z\n" +
                "           M 789.00,556.00\n" +
                "           C 789.00,556.00 790.00,557.00 790.00,557.00\n" +
                "             790.00,557.00 790.00,556.00 790.00,556.00\n" +
                "             790.00,556.00 789.00,556.00 789.00,556.00 Z\n" +
                "           M 822.00,556.00\n" +
                "           C 822.00,556.00 823.00,557.00 823.00,557.00\n" +
                "             823.00,557.00 823.00,556.00 823.00,556.00\n" +
                "             823.00,556.00 822.00,556.00 822.00,556.00 Z\n" +
                "           M 778.00,559.00\n" +
                "           C 778.00,559.00 779.00,560.00 779.00,560.00\n" +
                "             779.00,560.00 779.00,559.00 779.00,559.00\n" +
                "             779.00,559.00 778.00,559.00 778.00,559.00 Z\n" +
                "           M 824.00,563.00\n" +
                "           C 824.00,563.00 825.00,564.00 825.00,564.00\n" +
                "             825.00,564.00 825.00,563.00 825.00,563.00\n" +
                "             825.00,563.00 824.00,563.00 824.00,563.00 Z\n" +
                "           M 685.00,497.46\n" +
                "           C 685.00,497.46 693.00,496.83 693.00,496.83\n" +
                "             702.27,495.93 705.57,495.62 715.00,497.67\n" +
                "             719.53,498.65 725.13,500.62 728.91,503.30\n" +
                "             742.70,513.10 738.83,540.79 739.00,556.00\n" +
                "             739.09,563.22 741.19,566.75 740.00,574.00\n" +
                "             740.00,574.00 743.00,580.00 743.00,580.00\n" +
                "             743.00,580.00 721.00,580.00 721.00,580.00\n" +
                "             721.00,580.00 714.53,579.01 714.53,579.01\n" +
                "             714.53,579.01 711.00,573.00 711.00,573.00\n" +
                "             701.61,577.84 696.48,582.51 685.00,582.96\n" +
                "             670.09,583.55 653.97,574.94 655.32,558.00\n" +
                "             656.89,538.38 674.28,535.20 690.00,531.65\n" +
                "             695.58,530.39 704.95,529.86 707.54,524.00\n" +
                "             710.54,517.19 702.11,514.71 697.00,515.25\n" +
                "             689.89,515.99 686.85,520.66 685.00,527.00\n" +
                "             685.00,527.00 658.00,526.00 658.00,526.00\n" +
                "             656.56,509.08 669.90,500.14 685.00,497.46 Z\n" +
                "           M 667.00,510.00\n" +
                "           C 667.00,510.00 668.00,511.00 668.00,511.00\n" +
                "             668.00,511.00 668.00,510.00 668.00,510.00\n" +
                "             668.00,510.00 667.00,510.00 667.00,510.00 Z\n" +
                "           M 686.43,551.63\n" +
                "           C 682.31,555.72 685.00,561.68 690.04,563.35\n" +
                "             698.61,566.20 706.31,561.34 708.77,553.09\n" +
                "             709.96,549.71 711.28,546.02 708.77,543.35\n" +
                "             704.38,542.80 689.58,548.51 686.43,551.63 Z\n" +
                "           M 710.00,555.00\n" +
                "           C 710.00,555.00 711.00,556.00 711.00,556.00\n" +
                "             711.00,556.00 711.00,555.00 711.00,555.00\n" +
                "             711.00,555.00 710.00,555.00 710.00,555.00 Z\n" +
                "           M 701.00,564.00\n" +
                "           C 701.00,564.00 702.00,565.00 702.00,565.00\n" +
                "             702.00,565.00 702.00,564.00 702.00,564.00\n" +
                "             702.00,564.00 701.00,564.00 701.00,564.00 Z\n" +
                "           M 701.00,576.00\n" +
                "           C 701.00,576.00 702.00,577.00 702.00,577.00\n" +
                "             702.00,577.00 702.00,576.00 702.00,576.00\n" +
                "             702.00,576.00 701.00,576.00 701.00,576.00 Z\n" +
                "           M 589.00,554.00\n" +
                "           C 590.94,554.01 593.82,553.85 595.44,555.02\n" +
                "             597.28,556.35 597.51,559.04 600.22,561.86\n" +
                "             604.51,566.29 615.00,568.04 619.26,562.61\n" +
                "             624.39,556.07 615.13,551.27 610.00,550.04\n" +
                "             610.00,550.04 596.00,547.88 596.00,547.88\n" +
                "             584.58,545.50 572.38,539.65 570.50,527.00\n" +
                "             569.87,524.19 570.08,521.77 570.50,519.00\n" +
                "             573.10,507.61 580.30,502.60 591.00,499.44\n" +
                "             601.87,496.22 609.99,496.39 621.00,498.39\n" +
                "             635.45,501.01 646.21,506.76 647.00,523.07\n" +
                "             647.00,523.07 624.01,523.07 624.01,523.07\n" +
                "             618.60,522.37 616.98,515.96 610.00,514.64\n" +
                "             606.39,513.96 601.06,515.54 599.42,519.10\n" +
                "             596.38,525.70 607.89,527.57 612.00,528.25\n" +
                "             628.72,531.01 648.48,534.10 649.90,555.00\n" +
                "             650.90,569.54 640.07,578.83 627.00,582.24\n" +
                "             608.73,587.01 576.32,584.67 569.80,563.00\n" +
                "             568.89,559.99 569.01,557.09 569.00,554.00\n" +
                "             569.00,554.00 589.00,554.00 589.00,554.00 Z\n" +
                "           M 600.00,547.00\n" +
                "           C 600.00,547.00 601.00,548.00 601.00,548.00\n" +
                "             601.00,548.00 601.00,547.00 601.00,547.00\n" +
                "             601.00,547.00 600.00,547.00 600.00,547.00 Z\n" +
                "           M 571.00,562.00\n" +
                "           C 571.00,562.00 572.00,563.00 572.00,563.00\n" +
                "             572.00,563.00 572.00,562.00 572.00,562.00\n" +
                "             572.00,562.00 571.00,562.00 571.00,562.00 Z\n" +
                "           M 618.00,567.00\n" +
                "           C 618.00,567.00 619.00,568.00 619.00,568.00\n" +
                "             619.00,568.00 619.00,567.00 619.00,567.00\n" +
                "             619.00,567.00 618.00,567.00 618.00,567.00 Z\n" +
                "           M 480.77,519.72\n" +
                "           C 480.96,516.73 482.68,513.52 484.29,511.00\n" +
                "             491.34,499.93 502.95,498.04 515.00,496.83\n" +
                "             515.00,496.83 526.00,495.72 526.00,495.72\n" +
                "             526.00,495.72 537.00,497.60 537.00,497.60\n" +
                "             543.19,498.87 548.92,500.88 553.67,505.24\n" +
                "             565.19,515.80 561.71,536.15 561.10,550.00\n" +
                "             560.89,554.91 564.32,574.84 566.00,579.84\n" +
                "             566.00,579.84 539.10,579.84 539.10,579.84\n" +
                "             539.10,579.84 531.90,575.11 531.90,575.11\n" +
                "             531.90,575.11 522.00,578.00 522.00,578.00\n" +
                "             518.39,582.72 510.50,583.03 505.00,582.88\n" +
                "             489.64,582.47 475.79,573.00 478.30,556.00\n" +
                "             480.83,538.79 497.66,534.81 512.00,532.00\n" +
                "             516.94,531.03 526.16,529.83 529.26,525.66\n" +
                "             533.92,519.38 524.62,514.53 519.28,515.12\n" +
                "             510.02,516.14 510.10,524.49 505.78,526.40\n" +
                "             503.41,527.45 484.97,527.00 480.77,527.00\n" +
                "             480.74,524.79 480.23,521.88 480.77,519.72 Z\n" +
                "           M 491.00,506.00\n" +
                "           C 491.00,506.00 492.00,507.00 492.00,507.00\n" +
                "             492.00,507.00 492.00,506.00 492.00,506.00\n" +
                "             492.00,506.00 491.00,506.00 491.00,506.00 Z\n" +
                "           M 495.00,537.00\n" +
                "           C 495.00,537.00 496.00,538.00 496.00,538.00\n" +
                "             496.00,538.00 496.00,537.00 496.00,537.00\n" +
                "             496.00,537.00 495.00,537.00 495.00,537.00 Z\n" +
                "           M 522.00,545.65\n" +
                "           C 518.66,546.76 515.08,547.51 512.05,549.36\n" +
                "             505.11,553.60 506.61,560.77 512.05,563.15\n" +
                "             520.10,566.66 528.08,561.19 531.37,554.00\n" +
                "             533.32,549.72 533.00,547.53 533.00,543.00\n" +
                "             527.32,543.31 527.15,543.93 522.00,545.65 Z\n" +
                "           M 365.00,501.00\n" +
                "           C 365.00,501.00 372.01,502.57 372.01,502.57\n" +
                "             372.01,502.57 376.16,513.00 376.16,513.00\n" +
                "             376.16,513.00 385.00,539.00 385.00,539.00\n" +
                "             385.00,539.00 393.58,513.00 393.58,513.00\n" +
                "             393.58,513.00 398.42,501.77 398.42,501.77\n" +
                "             398.42,501.77 416.00,501.00 416.00,501.00\n" +
                "             416.00,501.00 424.18,502.60 424.18,502.60\n" +
                "             424.18,502.60 428.13,514.00 428.13,514.00\n" +
                "             428.13,514.00 436.00,539.00 436.00,539.00\n" +
                "             436.00,539.00 445.30,513.00 445.30,513.00\n" +
                "             445.30,513.00 450.41,502.02 450.41,502.02\n" +
                "             450.41,502.02 456.00,501.00 456.00,501.00\n" +
                "             456.00,501.00 479.00,501.00 479.00,501.00\n" +
                "             479.00,501.00 472.35,524.00 472.35,524.00\n" +
                "             472.35,524.00 460.78,562.00 460.78,562.00\n" +
                "             460.78,562.00 454.44,578.98 454.44,578.98\n" +
                "             454.44,578.98 447.00,580.00 447.00,580.00\n" +
                "             447.00,580.00 424.00,580.00 424.00,580.00\n" +
                "             424.00,580.00 412.00,541.00 412.00,541.00\n" +
                "             412.00,541.00 410.00,541.00 410.00,541.00\n" +
                "             410.00,541.00 400.00,580.00 400.00,580.00\n" +
                "             400.00,580.00 376.00,580.00 376.00,580.00\n" +
                "             376.00,580.00 368.43,578.98 368.43,578.98\n" +
                "             368.43,578.98 361.57,562.00 361.57,562.00\n" +
                "             361.57,562.00 346.65,519.00 346.65,519.00\n" +
                "             346.65,519.00 341.00,500.00 341.00,500.00\n" +
                "             341.00,500.00 365.00,501.00 365.00,501.00 Z\n" +
                "           M 428.00,520.00\n" +
                "           C 428.00,520.00 429.00,521.00 429.00,521.00\n" +
                "             429.00,521.00 429.00,520.00 429.00,520.00\n" +
                "             429.00,520.00 428.00,520.00 428.00,520.00 Z\n" +
                "           M 465.00,539.00\n" +
                "           C 465.00,539.00 466.00,540.00 466.00,540.00\n" +
                "             466.00,540.00 466.00,539.00 466.00,539.00\n" +
                "             466.00,539.00 465.00,539.00 465.00,539.00 Z\n" +
                "           M 269.00,527.00\n" +
                "           C 266.75,527.00 262.36,527.24 260.57,525.83\n" +
                "             258.59,524.25 259.21,521.14 259.63,519.00\n" +
                "             260.73,513.39 263.38,508.58 268.05,505.18\n" +
                "             277.77,498.11 291.09,495.74 303.00,496.01\n" +
                "             308.63,496.14 309.20,496.96 314.00,497.71\n" +
                "             316.84,498.14 319.13,498.06 322.00,498.99\n" +
                "             333.18,502.61 340.15,513.35 339.90,524.83\n" +
                "             339.65,535.91 339.74,562.04 342.13,572.00\n" +
                "             342.13,572.00 345.00,580.00 345.00,580.00\n" +
                "             345.00,580.00 323.00,580.00 323.00,580.00\n" +
                "             323.00,580.00 315.61,579.01 315.61,579.01\n" +
                "             315.61,579.01 312.00,573.00 312.00,573.00\n" +
                "             305.86,576.21 301.08,580.09 294.00,581.83\n" +
                "             276.30,586.17 256.51,578.93 257.01,558.00\n" +
                "             257.46,539.76 275.13,534.76 290.00,532.08\n" +
                "             295.28,531.13 306.60,529.43 308.87,523.96\n" +
                "             311.38,517.92 302.16,514.25 297.42,514.85\n" +
                "             290.42,515.73 288.22,521.33 286.00,527.00\n" +
                "             286.00,527.00 269.00,527.00 269.00,527.00 Z\n" +
                "           M 288.23,551.27\n" +
                "           C 283.42,556.07 287.10,562.23 292.09,563.58\n" +
                "             300.29,565.80 306.88,561.48 309.81,554.00\n" +
                "             311.41,550.48 312.80,546.08 309.81,543.35\n" +
                "             305.23,542.72 291.44,548.08 288.23,551.27 Z\n" +
                "           M 178.00,469.00\n" +
                "           C 178.00,469.00 179.00,504.00 179.00,504.00\n" +
                "             179.00,504.00 204.00,480.00 204.00,480.00\n" +
                "             210.50,473.51 212.47,469.06 222.00,469.00\n" +
                "             222.00,469.00 251.00,469.00 251.00,469.00\n" +
                "             251.00,469.00 252.00,473.00 252.00,473.00\n" +
                "             252.00,473.00 222.77,502.30 222.77,502.30\n" +
                "             220.06,505.01 213.05,510.30 213.37,514.42\n" +
                "             213.62,517.72 220.35,526.04 222.52,529.09\n" +
                "             222.52,529.09 242.38,558.00 242.38,558.00\n" +
                "             245.99,563.01 251.46,568.71 252.00,575.00\n" +
                "             255.82,576.50 255.95,577.10 257.00,581.00\n" +
                "             257.00,581.00 221.00,580.00 221.00,580.00\n" +
                "             221.00,580.00 215.55,579.01 215.55,579.01\n" +
                "             215.55,579.01 202.91,560.00 202.91,560.00\n" +
                "             202.91,560.00 197.00,548.00 197.00,548.00\n" +
                "             191.67,544.92 191.38,540.32 188.57,539.69\n" +
                "             185.81,539.07 180.38,545.82 179.31,548.00\n" +
                "             176.62,553.53 178.73,572.55 178.00,580.00\n" +
                "             178.00,580.00 146.00,580.00 146.00,580.00\n" +
                "             146.00,580.00 146.00,469.00 146.00,469.00\n" +
                "             146.00,469.00 178.00,469.00 178.00,469.00 Z\n" +
                "           M 149.00,470.00\n" +
                "           C 149.00,470.00 150.00,471.00 150.00,471.00\n" +
                "             150.00,471.00 150.00,470.00 150.00,470.00\n" +
                "             150.00,470.00 149.00,470.00 149.00,470.00 Z\n" +
                "           M 186.00,500.00\n" +
                "           C 186.00,500.00 187.00,501.00 187.00,501.00\n" +
                "             187.00,501.00 187.00,500.00 187.00,500.00\n" +
                "             187.00,500.00 186.00,500.00 186.00,500.00 Z\n" +
                "           M 212.00,518.00\n" +
                "           C 212.00,518.00 213.00,519.00 213.00,519.00\n" +
                "             213.00,519.00 213.00,518.00 213.00,518.00\n" +
                "             213.00,518.00 212.00,518.00 212.00,518.00 Z\n" +
                "           M 188.00,536.00\n" +
                "           C 188.00,536.00 189.00,537.00 189.00,537.00\n" +
                "             189.00,537.00 189.00,536.00 189.00,536.00\n" +
                "             189.00,536.00 188.00,536.00 188.00,536.00 Z\n" +
                "           M 194.00,544.00\n" +
                "           C 194.00,544.00 195.00,545.00 195.00,545.00\n" +
                "             195.00,545.00 195.00,544.00 195.00,544.00\n" +
                "             195.00,544.00 194.00,544.00 194.00,544.00 Z\n" +
                "           M 239.00,557.00\n" +
                "           C 239.00,557.00 240.00,558.00 240.00,558.00\n" +
                "             240.00,558.00 240.00,557.00 240.00,557.00\n" +
                "             240.00,557.00 239.00,557.00 239.00,557.00 Z\n" +
                "           M 147.00,405.00\n" +
                "           C 147.00,405.00 147.00,366.00 147.00,366.00\n" +
                "             147.00,366.00 147.00,238.00 147.00,238.00\n" +
                "             147.00,238.00 147.00,191.00 147.00,191.00\n" +
                "             147.06,182.59 147.83,183.02 162.00,183.00\n" +
                "             162.00,183.00 365.00,183.00 365.00,183.00\n" +
                "             365.00,183.00 365.00,271.00 365.00,271.00\n" +
                "             365.00,271.00 365.00,291.00 365.00,291.00\n" +
                "             364.98,293.37 364.34,296.93 366.45,298.56\n" +
                "             368.69,300.28 372.71,299.31 375.42,299.13\n" +
                "             375.42,299.13 392.96,299.13 392.96,299.13\n" +
                "             392.96,299.13 415.00,297.96 415.00,297.96\n" +
                "             415.00,297.96 425.00,297.96 425.00,297.96\n" +
                "             425.00,297.96 433.00,296.60 433.00,296.60\n" +
                "             433.00,296.60 439.00,296.60 439.00,296.60\n" +
                "             439.00,296.60 456.00,294.29 456.00,294.29\n" +
                "             456.00,294.29 502.00,286.67 502.00,286.67\n" +
                "             502.00,286.67 533.00,277.56 533.00,277.56\n" +
                "             538.80,275.46 544.73,271.87 551.00,272.00\n" +
                "             551.90,268.95 555.27,267.78 558.00,266.31\n" +
                "             558.00,266.31 576.72,255.69 576.72,255.69\n" +
                "             591.59,245.26 616.29,223.65 606.60,203.00\n" +
                "             601.13,191.33 596.63,191.54 589.00,184.00\n" +
                "             589.00,184.00 619.00,183.00 619.00,183.00\n" +
                "             619.00,183.00 667.00,183.00 667.00,183.00\n" +
                "             667.00,183.00 816.00,183.00 816.00,183.00\n" +
                "             816.00,183.00 858.00,183.00 858.00,183.00\n" +
                "             858.00,183.00 878.00,183.00 878.00,183.00\n" +
                "             878.00,183.00 879.00,184.00 879.00,184.00\n" +
                "             876.94,191.11 874.83,206.65 869.00,211.00\n" +
                "             868.99,216.10 866.42,219.73 863.80,223.99\n" +
                "             858.28,232.92 850.01,243.29 842.28,250.34\n" +
                "             816.71,273.65 789.91,286.30 757.00,295.97\n" +
                "             757.00,295.97 732.00,301.68 732.00,301.68\n" +
                "             725.30,302.84 720.28,302.55 714.00,306.00\n" +
                "             722.56,306.77 742.12,311.90 751.00,314.27\n" +
                "             786.93,323.83 825.21,340.78 851.65,367.42\n" +
                "             864.99,380.86 872.10,393.75 876.66,412.00\n" +
                "             878.56,419.59 878.97,417.46 879.00,426.00\n" +
                "             879.00,426.00 584.00,426.00 584.00,426.00\n" +
                "             584.00,426.00 603.00,411.56 603.00,411.56\n" +
                "             603.00,411.56 612.00,405.00 612.00,405.00\n" +
                "             613.58,397.22 617.33,395.96 617.91,386.00\n" +
                "             619.27,362.42 588.83,344.39 570.00,336.80\n" +
                "             564.32,334.51 558.17,331.24 552.00,331.00\n" +
                "             548.61,328.12 544.16,327.39 540.00,325.88\n" +
                "             540.00,325.88 511.00,317.26 511.00,317.26\n" +
                "             492.03,312.00 470.60,309.04 451.00,307.00\n" +
                "             451.00,307.00 442.00,307.00 442.00,307.00\n" +
                "             442.00,307.00 427.00,305.02 427.00,305.02\n" +
                "             427.00,305.02 417.00,305.02 417.00,305.02\n" +
                "             417.00,305.02 404.00,303.95 404.00,303.95\n" +
                "             404.00,303.95 389.00,303.95 389.00,303.95\n" +
                "             377.70,303.27 375.84,301.86 364.00,305.00\n" +
                "             364.00,305.00 365.00,337.00 365.00,337.00\n" +
                "             365.00,337.00 365.00,399.00 365.00,399.00\n" +
                "             365.00,399.00 365.00,419.00 365.00,419.00\n" +
                "             365.00,419.00 363.40,424.98 363.40,424.98\n" +
                "             363.40,424.98 356.00,426.00 356.00,426.00\n" +
                "             356.00,426.00 216.00,426.00 216.00,426.00\n" +
                "             216.00,426.00 171.00,426.00 171.00,426.00\n" +
                "             171.00,426.00 148.00,426.00 148.00,426.00\n" +
                "             146.30,420.03 147.00,411.38 147.00,405.00 Z\n" +
                "           M 853.00,235.00\n" +
                "           C 853.00,235.00 854.00,236.00 854.00,236.00\n" +
                "             854.00,236.00 854.00,235.00 854.00,235.00\n" +
                "             854.00,235.00 853.00,235.00 853.00,235.00 Z\n" +
                "           M 832.00,254.00\n" +
                "           C 832.00,254.00 833.00,255.00 833.00,255.00\n" +
                "             833.00,255.00 833.00,254.00 833.00,254.00\n" +
                "             833.00,254.00 832.00,254.00 832.00,254.00 Z\n" +
                "           M 562.00,267.00\n" +
                "           C 562.00,267.00 563.00,268.00 563.00,268.00\n" +
                "             563.00,268.00 563.00,267.00 563.00,267.00\n" +
                "             563.00,267.00 562.00,267.00 562.00,267.00 Z\n" +
                "           M 776.00,286.00\n" +
                "           C 776.00,286.00 777.00,287.00 777.00,287.00\n" +
                "             777.00,287.00 777.00,286.00 777.00,286.00\n" +
                "             777.00,286.00 776.00,286.00 776.00,286.00 Z\n" +
                "           M 598.00,348.00\n" +
                "           C 598.00,348.00 599.00,349.00 599.00,349.00\n" +
                "             599.00,349.00 599.00,348.00 599.00,348.00\n" +
                "             599.00,348.00 598.00,348.00 598.00,348.00 Z\n" +
                "           M 824.00,348.00\n" +
                "           C 824.00,348.00 825.00,349.00 825.00,349.00\n" +
                "             825.00,349.00 825.00,348.00 825.00,348.00\n" +
                "             825.00,348.00 824.00,348.00 824.00,348.00 Z\n" +
                "           M 870.00,399.00\n" +
                "           C 870.00,399.00 871.00,400.00 871.00,400.00\n" +
                "             871.00,400.00 871.00,399.00 871.00,399.00\n" +
                "             871.00,399.00 870.00,399.00 870.00,399.00 Z";

}