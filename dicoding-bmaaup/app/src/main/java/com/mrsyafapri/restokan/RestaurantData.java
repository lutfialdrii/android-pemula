package com.mrsyafapri.restokan;

import java.util.ArrayList;

public class RestaurantData {
    private static final String[] restaurantNames = {
            "American Food",
            "Anak Senja",
            "Easy Eat",
            "KafeIn",
            "Kopi Bersama",
            "Kumpul Kerja",
            "Modern Coffee",
            "Party Kafe",
            "Sederhana",
            "Teras Kita",
            "Warung Gopek"
    };

    private static final String[] restaurantDetails = {
            "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.",
            "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.",
            "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.",
            "Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure.",
            "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee humble.",
            "Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc.",
            "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores.",
            "At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es.Li Europan lingues es membres del sam familie.",
            "Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles.",
            "The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators. To achieve this, it would be necessary to have uniform grammar, pronunciation and more common words.",
            "If several languages coalesce, the grammar of the resulting language is more simple and regular than that of the individual languages. The new common language will be more simple and regular than the existing European languages. It will be as simple as Occidental; in fact, it will be Occidental. To an English person, it will seem like simplified English, as a skeptical Cambridge friend of mine told me what Occidental is.",
    };

    private static final double[] restaurantRatings = {
            4,
            5,
            4.5,
            4.7,
            3,
            4.2,
            3.9,
            4.8,
            4.4,
            3.5,
            4.9
    };

    private static final int[] restaurantImages = {
            R.drawable.american_food,
            R.drawable.anak_senja,
            R.drawable.easy_eat,
            R.drawable.kafein,
            R.drawable.kopi_bersama,
            R.drawable.kumpul_kerja,
            R.drawable.modern_coffee,
            R.drawable.party_kafe,
            R.drawable.sederhana,
            R.drawable.teras_kita,
            R.drawable.warung_gopek
    };

    private static final String[] restaurantAddress = {
            "Jalan Sudirman, Jakarta",
            "Jalan Diponegoro, Pekanbaru",
            "Jalan M. Boya, Tembilahan",
            "Jalan Paus, Pekanbaru",
            "Jalan Budiman, Padang",
            "Jalan Bersama, Bandung",
            "Jalan Soebrantas, Jambi",
            "Jalan Merdeka, Surabaya",
            "Jalan Ahmad Yani, Medan",
            "Jalan Kartini, Banjarmasin",
            "Jalan Batang Tuaka, Lampung"
    };

    static ArrayList<Restaurant> getListData() {
        ArrayList<Restaurant> list = new ArrayList<>();
        for (int position = 0; position < restaurantNames.length; position++) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(restaurantNames[position]);
            restaurant.setDesc(restaurantDetails[position]);
            restaurant.setAddress(restaurantAddress[position]);
            restaurant.setRating(restaurantRatings[position]);
            restaurant.setPhoto(restaurantImages[position]);
            list.add(restaurant);
        }
        return list;
    }
}
