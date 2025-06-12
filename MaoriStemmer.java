// Generated from maori.sbl by Snowball 3.0.0 - https://snowballstem.org/

package org.tartarus.snowball.ext;

import org.tartarus.snowball.Among;

/**
 * This class implements the stemming algorithm defined by a snowball script.
 * <p>
 * Generated from maori.sbl by Snowball 3.0.0 - https://snowballstem.org/
 * </p>
 */
@SuppressWarnings("unused")
public class maoriStemmer extends org.tartarus.snowball.SnowballStemmer {

    private static final long serialVersionUID = 1L;

    private final static Among[] a_0 = {
        new Among("", -1, 6),
        new Among("\u00E4", 0, 1),
        new Among("\u00EB", 0, 2),
        new Among("\u00EF", 0, 3),
        new Among("\u00F6", 0, 4),
        new Among("\u00FC", 0, 5)
    };

    private final static Among[] a_1 = {
        new Among("a", -1, 1),
        new Among("nga", 0, 1),
        new Among("ia", 0, 1),
        new Among("ngia", 2, 1),
        new Among("hia", 2, 1),
        new Among("whia", 4, 1),
        new Among("kia", 2, 1),
        new Among("mia", 2, 1),
        new Among("ria", 2, 1),
        new Among("tia", 2, 1),
        new Among("wh\u0101ia", 2, 1),
        new Among("na", 0, 1),
        new Among("ina", 11, 1),
        new Among("whina", 12, 1),
        new Among("kina", 12, 1)
    };

    private static final char[] g_v = {17, 65, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4, 0, 0, 4, 0, 0, 0, 16, 0, 0, 0, 4 };

    private int I_p2;
    private int I_p1;
    private int I_pV;


    private boolean r_normalise_diaereses() {
        int among_var;
        while(true)
        {
            int v_1 = cursor;
            lab0: {
                bra = cursor;
                among_var = find_among(a_0);
                ket = cursor;
                switch (among_var) {
                    case 1:
                        slice_from("\u0101");
                        break;
                    case 2:
                        slice_from("\u0113");
                        break;
                    case 3:
                        slice_from("\u012B");
                        break;
                    case 4:
                        slice_from("\u014D");
                        break;
                    case 5:
                        slice_from("\u016B");
                        break;
                    case 6:
                        if (cursor >= limit)
                        {
                            break lab0;
                        }
                        cursor++;
                        break;
                }
                continue;
            }
            cursor = v_1;
            break;
        }
        return true;
    }

    private boolean r_mark_regions() {
        I_pV = limit;
        I_p1 = limit;
        I_p2 = limit;
        int v_1 = cursor;
        lab0: {
            if (!go_out_grouping(g_v, 97, 363))
            {
                break lab0;
            }
            cursor++;
            I_pV = cursor;
        }
        cursor = v_1;
        int v_2 = cursor;
        lab1: {
            if (!go_out_grouping(g_v, 97, 363))
            {
                break lab1;
            }
            cursor++;
            if (!go_in_grouping(g_v, 97, 363))
            {
                break lab1;
            }
            cursor++;
            I_p1 = cursor;
            if (!go_out_grouping(g_v, 97, 363))
            {
                break lab1;
            }
            cursor++;
            if (!go_in_grouping(g_v, 97, 363))
            {
                break lab1;
            }
            cursor++;
            I_p2 = cursor;
        }
        cursor = v_2;
        return true;
    }

    private boolean r_RV() {
        return I_pV <= cursor;
    }

    private boolean r_verb_sfx() {
        ket = cursor;
        if (find_among_b(a_1) == 0)
        {
            return false;
        }
        bra = cursor;
        if (!r_RV())
        {
            return false;
        }
        slice_del();
        return true;
    }

    @Override
    public boolean stem() {
        int v_1 = cursor;
        r_normalise_diaereses();
        cursor = v_1;
        r_mark_regions();
        limit_backward = cursor;
        cursor = limit;
        int v_2 = limit - cursor;
        r_verb_sfx();
        cursor = limit - v_2;
        cursor = limit_backward;
        return true;
    }

    @Override
    public boolean equals( Object o ) {
        return o instanceof maoriStemmer;
    }

    @Override
    public int hashCode() {
        return maoriStemmer.class.getName().hashCode();
    }

}
