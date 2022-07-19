package pos.machine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<ItemInfo> itemDetail =  getItemInfos(barcodes);
        return null;
    }

    public List<ItemInfo> getItemInfos(List<String> barcodes) {
        return ItemDataLoader.loadAllItemInfos();
    }

    
}
