package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import necklaceRefactoringKata.jewellery.Ring;

public class Packer {

    public static void packNecklace(Necklace item, JewelleryStorage storage) {
        if (item.stone == Jewel.Diamond)
            storage.safe.add(item);
        else if (!item.isLarge())
            storage.box.topShelf.add(item);
        else if (item.type == NecklaceType.Beads || item.type == NecklaceType.Chain)
            storage.tree.add(item);
        else if (item instanceof PendantNecklace pendantNecklace) {
            storage.tree.add(pendantNecklace.chain);
            storage.box.topShelf.add(pendantNecklace.pendant);
        }
    }

    public static void pack(Jewellery item, JewelleryStorage storage) {
        if (storage.IsInTravelRoll(item) && item instanceof Ring ring1)
            storage.box.ringCompartment.add(ring1);
        else if (storage.IsInTravelRoll(item) && !item.isLarge())
            storage.box.topShelf.add(item);
        else if (item.stone == Jewel.Diamond)
            storage.safe.add(item);
        else if (item instanceof Ring ring2)
            storage.box.ringCompartment.add(ring2);
        else if (item.isSmall())
            storage.box.topShelf.add(item);
        else if (item instanceof Earring earring) {
            if (earring.type == EarringType.Hoop)
                storage.tree.add(earring);
            else if (earring.type == EarringType.Drop && earring.stone != Jewel.Plain)
                storage.box.topShelf.add(earring);
            else if (earring.type == EarringType.Drop)
                storage.box.mainSection.add(earring);
        } else if (item instanceof Necklace necklace) {
            if (necklace.type == NecklaceType.Beads || necklace.type == NecklaceType.Chain)
                storage.tree.add(necklace);
            else if (necklace instanceof PendantNecklace pendantNecklace) {
                storage.tree.add(pendantNecklace.chain);
                storage.box.topShelf.add(pendantNecklace.pendant);
            }
        } else
            storage.dresserTop.add(item);

        if (storage.IsInTravelRoll(item))
            storage.travelRoll.remove(item);
    }
}
