package projeOdev;

import java.util.*;

class projeOdev {

	public static void main(String[] args) {

		Scanner girdi = new Scanner(System.in);
		sorular kelimeSorular = new sorular();
		int soruSayisi = 1;
		int toplamPuan = 0;
		int rastgele;
		int sayac = 0;

		for (int i = 0; i < 14; i++) {

			// KEL�ME UZUNLUK ALMA
			int kelimeUzunluk = kelimeSorular.sorular[i][0].length();

			// KEL�MEY� KARAKTER D�Z�S�NE ATAMA
			char[] kelime = kelimeSorular.sorular[i][0].toCharArray();

			// PUANLAMA
			int puan = 100 * kelimeUzunluk;

			// SORU SAYISI BA�LIK
			System.out.println(
					ConsoleColors.BLUE_BOLD + "********************" + soruSayisi + ".SORU" + "********************");
			System.out.println(ConsoleColors.RESET);

			// KEL�MEY� G�ZLEME
			char[] gizliKelime = new char[kelimeUzunluk];
			for (int k = 0; k < kelimeUzunluk; k++) {
				gizliKelime[k] = '-';
			}
			System.out.println(Arrays.toString(gizliKelime) + "(" + kelimeSorular.sorular[i][1] + ")");
			System.out.println(ConsoleColors.BLUE_BOLD + "**********************************************");
			System.out.println(ConsoleColors.RESET);

			// HARF ALMA VE TAHM�N ETME
			ArrayList<String> rastgeleList = new ArrayList<>();
			String harfAlma = null;
			do {

				// HATALI HARF G�R���
				boolean x = false;
				String harfAl = null;
				System.out.println("HARF ALMAK ���N->(h)//TAHM�N ���N->(t) YAZINIZ");
				harfAl = girdi.next();
				while (!x) {
					if (harfAl.equals("h") || harfAl.equals("t")) {
						x = true;
						break;
					} else {
						System.err.println("HATALI G�R��!!!");
						System.out.println("HARF ALMAK ���N->(h)//TAHM�N ���N->(t) YAZINIZ");
						harfAl = girdi.next();
					}
				}
				harfAlma = harfAl;

				// HARF ALMA
				if (harfAlma != null && harfAlma.equals("h")) {
					sayac++;
					puan = puan - 100;
					boolean alma = false;
					while (!alma) {
						rastgele = (int) Math.round(Math.random() * (kelimeUzunluk - 1));
						if (rastgeleList.size() == 0) {
							rastgeleList.add(String.valueOf(rastgele));
							gizliKelime[rastgele] = kelime[rastgele];
							System.out.println(Arrays.toString(gizliKelime));
							alma = true;
						} else {
							for (int k = 0; k < rastgeleList.size(); k++) {
								if (rastgeleList.contains(String.valueOf(rastgele))) {
									rastgele = (int) Math.round(Math.random() * (kelimeUzunluk - 1));
								} else {
									rastgeleList.add(String.valueOf(rastgele));
									gizliKelime[rastgele] = kelime[rastgele];
									System.out.println(Arrays.toString(gizliKelime));
									alma = true;
								}
							}
						}
					}

					// B�T�N HARFLER A�ILIRSA
					if (sayac == kelimeUzunluk) {
						System.out.println(ConsoleColors.BLACK_BOLD + "KEL�ME: " + kelimeSorular.sorular[i][0]);
						System.out.println(ConsoleColors.RED_BOLD + "BU SORUDAN PUAN ALAMADINIZ");
						System.out.println(ConsoleColors.RESET);
						sayac = 0;
						break;
					}

					// TAHM�N ETME
				} else if (harfAlma != null && harfAlma.equals("t")) {
					System.out.print("TAHM�N�N�Z� G�R�N�Z: ");
					String tahmin = girdi.next();
					tahmin = tahmin.toUpperCase();
					if (tahmin.equals(kelimeSorular.sorular[i][0])) {
						System.out.println(ConsoleColors.GREEN_BOLD + "DO�RU TAHM�N YAPTINIZ PUANINIZ: " + puan);
						System.out.println(ConsoleColors.RESET);
						break;
					} else {
						System.out.println(ConsoleColors.RED_BOLD + "TAHM�N�N�Z YANLI� BU SORUDAN PUAN ALAMADINIZ");
						System.out.println(ConsoleColors.BLACK_BOLD + "DO�RU KEL�ME: " + kelimeSorular.sorular[i][0]);
						System.out.println(ConsoleColors.RESET);
						puan = 0;
						break;
					}
				}
			} while (harfAlma.equals("h") && harfAlma != null);

			// TOPLAM PUAN HESAPLAMA
			int x = puan;
			toplamPuan = toplamPuan + x;
			soruSayisi++;
		}

		// SONU�LAR
		System.out.println(ConsoleColors.BLUE_BOLD + "**********************************************");
		System.out.println(ConsoleColors.GREEN_BOLD + "YARI�MAMIZ B�TT� KATILDI�INIZ TE�EKK�RLER...");
		System.out.println("TOPLAM PUANINIZ: " + toplamPuan);
	}

}
