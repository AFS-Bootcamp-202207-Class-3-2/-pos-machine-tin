package pos.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PosMachine {
    public String printReceipt(List<String> barcodes) {

        return null;
    }
    public List<Receipt> convertToItemInfo() {
        List<ItemInfo> itemDetail =  getItemInfos();
        ArrayList<Receipt> receipts = new ArrayList<>();
        for (ItemInfo itemInfo : itemDetail) {
            Receipt receipt = new Receipt();
            receipt.setBarcode(itemInfo.getBarcode());
            receipt.setName(itemInfo.getName());
            receipt.setPrice(itemInfo.getPrice());
        }
        return receipts;
    }

    public List<ItemInfo> getItemInfos() {
        return ItemDataLoader.loadAllItemInfos();
    }


    public List<Receipt> calcToTalQuantityAndSubtotal(List<String> barcodes, List<Receipt> receipts) {
        HashMap<String, Integer> toTalQuantityMap = new HashMap<>();
        for (String barcode : barcodes) {
            if(toTalQuantityMap.containsKey(barcode)){
                toTalQuantityMap.put(barcode, toTalQuantityMap.get(barcode) + 1);
            }else{
                toTalQuantityMap.put(barcode, 1);
            }
        }
        for (Receipt receipt : receipts) {
            toTalQuantityMap.forEach((barcode,quantity)->{
                if(receipt.getBarcode() == barcode){
                    receipt.setQuantity(quantity);
                    receipt.setSubtotal(quantity * receipt.getPrice());
                }
            });
        }

        return receipts;
    }

    public Integer calcToTal(List<Receipt> receipts){
        int total = 0;
        for (Receipt receipt : receipts) {
            total += receipt.getSubtotal();
        }
        return total;
    }

    public String generateReceipt(List<Receipt> productDetails) {
        String receipt = "***<store earning no money>Receipt***\n";
        for (Receipt productDetail : productDetails) {
            receipt += "Name: " + productDetail.getName() + ", Quantity: "+ productDetail.getQuantity() +
                    ", Unit price: "+ productDetail.getPrice() +" (yuan), Subtotal: "
                    + productDetail.getSubtotal() +" (yuan)\n";
        }
        receipt +="----------------------\n" +
                "Total: "+ calcToTal(productDetails) +" (yuan)\n" +
                "**********************";
        return receipt;
    }
}
