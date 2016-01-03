/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationstart;

import java.text.DecimalFormat;

/**
 *
 * @author phempel
 */
public class Honorar {
// ARC double [][] hoai2013Tabelle34 7 SPALTEN, min 25000 max 25 Mio
//PM double [][]aho2014Heft9Tabelle7 7 Spalten, min 50.000 max 500 Mio 
//TW double [][] hoai2013Tabelle52 7 Spalten, min 10.000 max 15 Mio
//TGA double [][] hoai2013Tabelle56 5 Spalten, min 5.000 max 4 Mio
    public int Zone = 3;
    public int Abschlag = 50;
    public double AnrechenbareKosten;
    
    public double calculateHonorar (String tabelle, double ak, int zone, int abschlag)
    {
        double [][] honTabelle = {{0,0}};
        int AnzahlZeilen;
        double ak1;
        
        switch (tabelle)
        {
            case "arc":
                honTabelle = hoai2013Tabelle34;
               
                break;
            case "twp":
                honTabelle = hoai2013Tabelle52;
            
                break;
            case "tga":
                honTabelle = hoai2013Tabelle56;
               
                break;
            case "pm":
                honTabelle = aho2014Heft9Tabelle7;
             
                break;
        }
            
                AnzahlZeilen = honTabelle.length;
                ak1  = honTabelle[0][0];
                
            double h1;
            double h2;
            int Zeile = 0;
            double SpalteO [];
            double SpalteU [];
            
            double ak2;
            double h1o;
            double h1u;
            double h2o;
            double h2u;
        // ak muss geprüft werden
       while  (ak >= ak1)
       {
            Zeile = Zeile +1;
            ak1 = honTabelle[Zeile][0];
        
       }
        
        
        SpalteO = honTabelle[Zeile-1];
        ak1 = SpalteO[0];
        SpalteU = honTabelle[Zeile];
        h1o = SpalteO[zone];
        h2o = SpalteO[zone+1];
        h1u = SpalteU[zone];
        h2u = SpalteU[zone+1];
        ak2 = SpalteU[0];
        double zws1 = ak - ak1;
        double zws2 = ak2 - ak1;
        h1 = h1o + ((h1u-h1o)/zws2) * zws1;
        h2 = h2o + ((h2u - h2o)/zws2) * zws1;
        
        double honorar = h1 + ((h2-h1) * abschlag)/100;
                
        
        return honorar;
    };
    public String setArch(double AnK)
    {

        double ph1 = 0.02;
        double ph2 = 0.07;
        double ph3 = 0.15;
        double ph4 = 0.03;
        double zs1 = 0.27;               // ZwischenSumme
        
        double ph5 = 0.25;
        double ph6 = 0.10;
        double ph7 = 0.04;
        double zs2 = 0.39;
        
        double ph8 = 0.32;
        double ph9 = 0.02;
        double zs3 = 0.34;
        
        
        double grundhonorar = this.calculateHonorar("arc", AnK, Zone, Abschlag);
        
        
        String ErgebnisDruck = 
            "___________________________________________________________\n"+
            "Honorarberechnung nach § 35 HOAI, 2013\n"+
            "alle Angaben netto zzgl. MwSt\n\n"+
            String.format("Honorarzone			%s\n",Zone)+
            String.format("Honorarsatz			%s%%\n",Abschlag)+
            String.format("Anrechenbare Kosten	%,.2f EUR\n",AnK)+
            String.format("Grundhonorar (100%%)	%,.2f EUR\n",grundhonorar)+
"\n"+
             
             "Leistungsphasen			vereinb.	Betrag\n"+
"\n"+
            String.format("1 Grundlagenermittlung			%,.0f%%	%,.2f EUR\n",ph1*100, grundhonorar*ph1)+
            String.format("2 Vorplanung					%,.0f%%	%,.2f EUR\n",ph2*100, grundhonorar*ph2)+
            String.format("3 Entwurfsplanung				%,.0f%%	%,.2f EUR\n",ph3*100, grundhonorar*ph3)+
            String.format("4 Genehmigungsplanung		%,.0f%%	%,.2f EUR\n",ph4*100, grundhonorar*ph4)+
            String.format("\nZWISCHENSUMME\nBAUGENEHMIGUNG				%,.2f EUR\n\n",grundhonorar*zs1)+
            String.format("5 Ausführungsplanung			%,.0f%%	%,.2f EUR\n",ph5*100, grundhonorar*ph5)+
            String.format("6 Vorbereitung der Vergabe		%,.0f%%	%,.2f EUR\n",ph6*100, grundhonorar*ph6)+
            String.format("7 Mitwirkung bei der Vergabe		%,.0f%%	%,.2f EUR\n",ph7*100, grundhonorar*ph7)+
            String.format("\nZWISCHENSUMME\nBAUVERGABE					%,.2f EUR\n\n",grundhonorar*zs2)+
            String.format("8 Objektüberwachung			%,.0f%%	%,.2f EUR\n",ph8*100, grundhonorar*ph8)+
            String.format("9 Objektbetreuung				%,.0f%%	%,.2f EUR\n",ph9*100, grundhonorar*ph9)+
            String.format("\nZWISCHENSUMME\nAUSFÜHRUNG					%,.2f EUR\n",grundhonorar*zs3)+
"\n"+
            String.format("Nettohonorar                  		100%%	%,.2f EUR\n",grundhonorar)+
            "___________________________________________________________\n";
        
        return ErgebnisDruck;
        
     
    }
    
    public String setTwp(double AnK)
    {

        double ph1 = 0.02;
        double ph2 = 0.07;
        double ph3 = 0.15;
        double ph4 = 0.03;
        double zs1 = 0.27;               // ZwischenSumme
        
        double ph5 = 0.25;
        double ph6 = 0.10;
        double ph7 = 0.04;
        double zs2 = 0.39;
        
        double ph8 = 0.32;
        double ph9 = 0.02;
        double zs3 = 0.34;
        
        
        double grundhonorar = this.calculateHonorar("arc", AnK, Zone, Abschlag);
        
        
        String ErgebnisDruck = 
            "___________________________________________________________\n"+
            "Honorarberechnung nach § 35 HOAI, 2013\n"+
            "alle Angaben netto zzgl. MwSt\n\n"+
            String.format("Honorarzone			%s\n",Zone)+
            String.format("Honorarsatz			%s%%\n",Abschlag)+
            String.format("Anrechenbare Kosten	%,.2f EUR\n",AnK)+
            String.format("Grundhonorar (100%%)	%,.2f EUR\n",grundhonorar)+
"\n"+
             
             "Leistungsphasen			vereinb.	Betrag\n"+
"\n"+
            String.format("1 Grundlagenermittlung			%,.0f%%	%,.2f EUR\n",ph1*100, grundhonorar*ph1)+
            String.format("2 Vorplanung					%,.0f%%	%,.2f EUR\n",ph2*100, grundhonorar*ph2)+
            String.format("3 Entwurfsplanung				%,.0f%%	%,.2f EUR\n",ph3*100, grundhonorar*ph3)+
            String.format("4 Genehmigungsplanung		%,.0f%%	%,.2f EUR\n",ph4*100, grundhonorar*ph4)+
            String.format("\nZWISCHENSUMME\nBAUGENEHMIGUNG				%,.2f EUR\n\n",grundhonorar*zs1)+
            String.format("5 Ausführungsplanung			%,.0f%%	%,.2f EUR\n",ph5*100, grundhonorar*ph5)+
            String.format("6 Vorbereitung der Vergabe		%,.0f%%	%,.2f EUR\n",ph6*100, grundhonorar*ph6)+
            String.format("7 Mitwirkung bei der Vergabe		%,.0f%%	%,.2f EUR\n",ph7*100, grundhonorar*ph7)+
            String.format("\nZWISCHENSUMME\nBAUVERGABE					%,.2f EUR\n\n",grundhonorar*zs2)+
            String.format("8 Objektüberwachung			%,.0f%%	%,.2f EUR\n",ph8*100, grundhonorar*ph8)+
            String.format("9 Objektbetreuung				%,.0f%%	%,.2f EUR\n",ph9*100, grundhonorar*ph9)+
            String.format("\nZWISCHENSUMME\nAUSFÜHRUNG					%,.2f EUR\n",grundhonorar*zs3)+
"\n"+
            String.format("Nettohonorar                  		100%%	%,.2f EUR\n",grundhonorar)+
            "___________________________________________________________\n";
        
        return ErgebnisDruck;
        
     
    }
    
    
   double [][] hoai2013Tabelle34 = 
   {
            {25000,3120,3657,4339,5412,6094,6631},
            {35000,4217,4942,5865,7315,8237,8962},
            {50000,5804,6801,8071,10066,11336,12333},
            {75000,8342,9776,11601,14469,16293,17727},
            {100000,10790,12644,15005,18713,21074,22928},
            {150000,15500,18164,21555,26883,30274,32938},
            {200000,20037,23480,27863,34751,39134,42578},
            {300000,28750,33692,39981,49864,56153,61095},
            {500000,45232,53006,62900,78449,88343,96118},
            {750000,64666,75781,89927,112156,126301,137416},
            {1000000,83182,97479,115675,144268,162464,176761},
            {1500000,119307,139813,165911,206923,233022,253527},
            {2000000,153965,180428,214108,267034,300714,327177},
            {3000000,220161,258002,306162,381843,430003,467843},
            {5000000,343879,402984,478207,596416,671640,730744},
            {7500000,493923,578816,686862,856648,964694,1049587},
            {10000000,638277,747981,887604,1107012,1246635,1356339},
            {15000000,915129,1072416,1272601,1587176,1787360,1944648},
            {20000000,1180414,1383298,1641513,2047281,2305496,2508380},
            {25000000,1436874,1683837,1998153,2492079,2806395,3053358}
        
   };
           
      double [][]aho2014Heft9Tabelle7 =
      {
            {500000,18065,22164,28248,33962,38121,44082},
            {1000000,32442,39695,50578,60718,68179,78814},
            {1500000,45426,55480,70674,84755,96194,110017},
            {2000000,57507,70128,89319,107026,120232,138929},
            {2500000,68915,83532,106886,127983,143801,166136},
            {3000000,79787,97064,123593,147894,166199,191985},
            {3500000,90214,109636,139585,166935,187623,216705},
            {4000000,100259,121728,154964,185230,208213,240459},
            {4500000,109971,133403,169809,202875,228074,263367},
            {5000000,119387,144705,184179,219940,247207,285524},
            {5500000,128537,155672,198121,236485,265918,307005},
            {6000000,137444,166336,211674,252557,284020,327873},
            {6500000,146129,176720,224871,268195,301636,348178},
            {7000000,154609,186847,237739,283433,318804,367963},
            {7500000,162899,196736,250302,298299,335557,387266},
            {6000000,171012,206401,262580,312819,351921,406120},
            {8500000,178958,215858,274591,327013,367922,424551},
            {9000000,186747,225118,286351,340902,383580,442586},
            {9500000,194389,234192,297874,354502,398915,460246},
            {10000000,201890,243090,309171,367828,413944,477551},
            {10500000,209259,251821,320256,380894,428682,494518},
            {11000000,216501,260393,331136,393712,443143,511164},
            {11500000,223621,268813,341823,406294,457339,527503},
            {12000000,230626,277088,352324,418650,471283,543549},
            {12500000,237521,285223,362647,430790,484984,559314},
            {13000000,244308,293225,372799,442721,498452,574809},
            {13500000,250994,301098,382787,454453,511697,590045},
            {14000000,257580,308847,392617,465992,524726,605030},
            {14500000,284072,316477,402294,477345,537547,619775},
            {15000000,270472,323992,411825,488519,550168,634288},
            {15500000,276783,331396,421212,499520,562595,648575},
            {16000000,283009,338691,430462,510353,574834,662645},
            {16500000,289151,345882,439579,521024,586891,676504},
            {17000000,295212,352972,448566,531537,598772,690158},
            {17500000,301196,359964,457427,541897,610482,703614},
            {18000000,307103,366860,466167,552109,622026,716878},
            {18500000,312937,373664,474788,562176,633408,729954},
            {19000000,318698,380377,483294,572103,644633,742848},
            {19500000,324390,387002,491687,581893,655705,755564},
            {20000000,330013,393541,499970,591550,666628,768107},
            {20500000,335569,399997,508147,601077,677405,780482},
            {21000000,341081,406371,516220,610477,688041,792692},
            {21500000,346490,412666,524191,619753,698538,804742},
            {22000000,351856,418883,532063,628908,708899,816634},
            {22500000,357162,425024,539838,637946,719129,828374},
            {23000000,362409,431091,547518,646867,729229,839963},
            {23500000,367598,437085,555105,655676,739203,851406},
            {24000000,372731,443008,562601,664374,749053,862706},
            {24500000,377808,448862,570009,672964,758782,873865},
            {25000000,382831,454647,577329,681448,768392,884886},
            {25500000,387800,460366,584564,689828,777886,895772},
            {26000000,392718,466019,591715,698106,787265,906526},
            {26500000,397584,471608,598784,706284,796533,917151},
            {27000000,402400,477133,605772,714364,805692,927648},
            {27500000,407167,482597,612681,722347,814742,938020},
            {28000000,411885,488000,619513,730236,823687,948270},
            {28500000,416556,491343,626269,738033,832527,968399},
            {29000000,421180,498628,632949,745738,841266,968410},
            {29500000,425758,503855,639556,753353,849905,978304},
            {30000000,430292,509026,646091,760881,858445,988084},
            {30500000,434781,514141,652554,768321,866888,997752},
            {31000000,439226,519201,658948,775677,875235,1007309},
            {31500000,443628,524207,665272,782949,883489,1016758},
            {32000000,447388,529160,671529,790138,891650,1026099},
            {32500000,452307,534061,677719,797246,899721,1035335},
            {33000000,456584,538910,683843,804274,907702,1044468},
            {33500000,460822,543709,689903,811223,915595,1053498},
            {34000000,465019,548458,695899,818095,923401,1062427},
            {34500000,469177,553158,701832,824890,931122,1071257},
            {35000000,473297,557810,707704,831610,938758,1079990},
            {35500000,477379,562413,713514,838256,946311,1088626},
            {36000000,481424,566970,719264,844828,953783,1097167},
            {36500000,485431,571480,724955,851329,961173,1105614},
            {37000000,489402,575945,730587,857758,968484,1113969},
            {37500000,493337,580364,736162,864117,975716,1122233},
            {38000000,497237,584739,741680,870406,982871,1130407},
            {38500000,501101,589070,747142,876627,989949,1138492},
            {39000000,504331,593357,752548,882781,996952,1146490},
            {39500000,508727,597601,757899,888868,1003880,1154401},
            {40000000,512489,601804,763196,894889,1010734,1162227},
            {41000000,519514,610084,773632,906738,1024226,1177627},
            {41500000,523578,614162,778771,912566,1030365,1185203},
            {42000000,527209,618200,783859,918332,1037434,1192697},
            {42500000,530309,622199,788896,924037,1043534,1200112},
            {43000000,534378,626158,793883,929680,1050365,1207447},
            {43500000,537515,630078,798820,935262,1056728,1214704},
            {44000000,541423,633960,803708,940785,1063525,1221883},
            {44500000,544399,637804,808547,946249,1069256,1228985},
            {45000000,548346,641610,813339,951654,1075421,1236012},
            {45500000,551764,645380,818083,957002,1081522,1242964},
            {46000000,555152,649112,822780,962293,1087559,1249841},
            {46500000,558511,652808,827431,967527,1093532,1256646},
            {47000000,561842,656469,832036,972705,1099443,1263377},
            {47500000,565144,660093,836595,977828,1105292,1270037},
            {48000000,568418,663683,841109,982896,1111580,1276627},
            {48500000,571665,667238,845579,987910,1116307,1283145},
            {49000000,574384,670758,850005,992870,1122475,1289595},
            {49500000,578076,674244,854388,997778,1128083,1295975},
            {50000000,581241,677697,858727,1002632,1133632,1302287},
            {51000000,586306,683602,866210,1012581,1144881,1315210},
            {75000000,814970,950213,1204039,1408552,1592588,1829524},
            {100000000,1039639,1212164,1535964,1797968,2032884,2335324},
            {125000000,1253988,1462085,1852646,2169796,2453293,2818279},
            {150000000,1460117,1702421,2157180,2527607,2857854,3283029},
            {175000000,1659407,1935882,2451613,2873762,3249237,3732640},
            {200000000,1852844,2160320,2737398,3209940,3629338,4169290},
            {225000000,2041164,2379891,3015622,3537393,3999576,4594609},
            {250000000,2224938,2594162,3287129,3857096,4361049,5009861},
            {275000000,2404621,2803662,3552593,4169826,4714640,5416057},
            {300000000,2580587,3008829,3812565,4476219,5061065,5814020},
            {325000000,2753145,3210024,4067504,4776805,5400924,6204442},
            {350000000,2922560,3407553,4317798,5072031,5734722,6587902},
            {375000000,3089056,3601678,4563779,5362281,6062896,6964899},
            {400000000,3252827,3792626,4805735,5647887,6385817,7335863},
            {425000000,3414045,3980598,5043918,5929139,6703817,7701173},
            {450000000,3572858,4165766,5278551,6206294,7017184,8061160},
            {475000000,3729403,4348289,5509830,6479580,7326177,8416123},
            {500000000,3883798,4528305,5737932,6749201,7631026,8766326} 
      };
      
      double [][] hoai2013Tabelle52 =
      {
                    {10000,1461,1624,2064,2575,3015,3178},
                    {15000,2011,2234,2841,3543,4149,4373},
                    {25000,3006,3340,4247,5296,6203,6537},
                    {50000,5187,5763,7327,9139,10703,11279},
                    {75000,7135,7928,10080,12572,14724,15517},
                    {100000,8946,9940,12639,15763,18461,19455},
                    {150000,12303,13670,17380,21677,25387,26754},
                    {250000,18370,20411,25951,32365,37906,39947},
                    {350000,23909,26565,33776,42125,49335,51992},
                    {500000,31594,35105,44633,55666,65194,68705},
                    {750000,43463,48293,61401,76578,89686,94515},
                    {1000000,54495,60550,76984,96014,112449,118504},
                    {1250000,64940,72155,91740,114418,134003,141218},
                    {1500000,74938,83265,105865,132034,154635,162961},
                    {2000000,93923,104358,132684,165483,193808,204244},
                    {3000000,129059,143398,182321,227389,266311,280651},
                    {5000000,192384,213760,271781,338962,396983,418359},
                    {7500000,264487,293874,373640,466001,545767,575154},
                    {10000000,331398,368220,468166,583892,683838,720660},
                    {15000000,455117,505686,642943,801873,939131,989699}
      };
      
      double [][] hoai2013Tabelle56 =
      {
                    {5000,2132,2547,2990,3405},
                    {10000,3689,4408,5174,5893},
                    {15000,5084,6075,7131,8122},
                    {25000,7615,9098,10681,12164},
                    {35000,9934,11869,13934,15869},
                    {50000,13165,15729,18465,21029},
                    {75000,18122,21652,25418,28948},
                    {100000,22723,27150,31872,36299},
                    {150000,31228,37311,43800,49883},
                    {250000,46640,55726,65418,74504},
                    {500000,80684,96402,113168,128886},
                    {750000,111105,132749,155836,177480},
                    {1000000,139347,166493,195448,222594},
                    {1250000,166043,198389,232891,265237},
                    {1500000,191545,228859,268660,305974},
                    {2000000,239792,286504,336331,383044},
                    {2500000,285649,341295,400650,456296},
                    {3000000,329420,393593,462044,526217},
                    {3500000,371491,443859,521052,593420},
                    {4000000,412126,492410,578046,658331}
      };

}