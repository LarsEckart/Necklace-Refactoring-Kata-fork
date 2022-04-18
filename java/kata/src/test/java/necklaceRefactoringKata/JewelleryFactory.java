package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import necklaceRefactoringKata.jewellery.Pendant;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import necklaceRefactoringKata.jewellery.Ring;

import java.util.ArrayList;
import java.util.Collection;

public class JewelleryFactory {
    static Collection<Necklace> allNecklaces() {
        var result = new ArrayList<Necklace>();
        for (Jewel jewel : Jewel.values()) {
            for (NecklaceType necklaceType : NecklaceType.values()) {
                result.add(new Necklace(jewel, necklaceType));
            }
        }
        return result;
    }

    static Collection<Necklace> allPendantNecklaces() {
        var result = new ArrayList<Necklace>();
        for (Jewellery jewellery : allRingsPendantsNecklacesEarrings()) {
            for (Necklace necklace : allNecklaces()) {
                for (Jewel jewel : Jewel.values()) {
                    for (NecklaceType necklaceType : NecklaceType.values()) {
                        result.add(new PendantNecklace(jewel, necklaceType, necklace, jewellery));
                    }
                }
            }
        }
        return result;
    }

    static Necklace[] necklaces() {
        return allNecklaces().toArray(new Necklace[0]);
    }

    static Jewellery[] allRingsPendantsNecklacesEarrings() {
        var result = new ArrayList<>();
        for (Jewel jewel : Jewel.values()) {
            result.add(new Ring(jewel));
            result.add(new Pendant(jewel));
            for (NecklaceType necklaceType : NecklaceType.values()) {
                result.add(new Necklace(jewel, necklaceType));
            }
            for (EarringType earringType : EarringType.values()) {
                result.add(new Earring(jewel, earringType));
            }
        }
        return result.toArray(new Jewellery[0]);
    }
}
