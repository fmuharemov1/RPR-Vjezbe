package ba.unsa.etf.rpr;
import java.util.Scanner;
public class Sat {
        static int sati, minute, sekunde;
        public static void Sat(int sati, int minute, int sekunde){
            Postavi(sati, minute, sekunde);
        }
        public static void Postavi(int sati, int minute, int sekunde ){
            Sat.sati = sati;
            Sat.minute = minute;
            Sat.sekunde = sekunde;
        }
        public static void Sljedeci(){
            Sat.sekunde++;
            if(Sat.sekunde == 60) {Sat.sekunde =0; Sat.minute ++;}
            if(Sat.minute == 60) {Sat.minute =0; Sat.sati++;}
            if(Sat.sati ==24) Sat.sati =0;
        }
        public static void Prethodni(){
            Sat.sekunde--;
            if(Sat.sekunde==-1) {Sat.sekunde=59; Sat.minute--;}
            if(Sat.minute == -1) {Sat.minute =59; Sat.sati--;}
            if(Sat.sati ==-1) Sat.sati =23;
        }
        public static void PomjeriZa(int pomak){
            if(pomak>0) for(int i=0; i<pomak; i++) Sljedeci();
            else for(int i=0; i<-pomak; i++) Prethodni();
        }
        public static int DajSate(){return Sat.sati;}
        public static int DajMinute(){return Sat.minute;}
        public static int DajSekunde(){return Sat.sekunde;}
        public static void Ispisi(){
            System.out.println(Sat.sati + ":" + Sat.minute + ":" + Sat.sekunde);
        }
    public static void main(String[] args) {
        Sat s = new Sat(15,30,45);
        s.Ispisi();
        s.Sljedeci();
        s.Ispisi();
        s.PomjeriZa(-48);
        s.Ispisi();
        s.Postavi(0,  0, 0);
        s.Ispisi();
        DajSate();
        DajMinute();
        DajSekunde();


    }
}
