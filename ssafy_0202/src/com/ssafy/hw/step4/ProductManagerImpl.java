package com.ssafy.hw.step4;

import java.util.Arrays;

public class ProductManagerImpl implements IProductManager {
    private static final int MAX_PRODUCT_SIZE = 100;
    private static final int MAX_REVIEW_SIZE = 1000;
    private Product[] products = new Product[MAX_PRODUCT_SIZE];
    private Review[] reviews = new Review[MAX_REVIEW_SIZE];
    private int pCount = 0;
    private int rCount = 0;

    @Override
    public boolean addProduct(Product product) {
        if (pCount < MAX_PRODUCT_SIZE) {
            products[pCount++] = product;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpCode() == product.getpCode()) {
                products[i] = product;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(String pCode) {
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpCode() == pCode) {
                for (int j = i; j < pCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                pCount--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int sell(String pCode, int cnt) {
        Product product = null;
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpCode() == pCode) {
                product = products[i];
                break;
            }
        }
        if (product.getQuantity() >= cnt) {
            product.setQuantity(product.getQuantity() - cnt);
            return product.getQuantity() - cnt;
        } else {
            return -1;
        }
    }

    @Override
    public Product[] getProductList() {
        return Arrays.copyOf(products, pCount);
    }

    @Override
    public Product searchByCode(String pCode) {
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpCode().equals(pCode)) {
                return products[i];
            }
        }
        return null;
    }

    @Override
    public Product[] searchByName(String name) {
        int cnt = 0;
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpName().contains(name)) {
                cnt++;
            }
        }

        Product[] result = new Product[cnt];
        int idx = 0;
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpName().contains(name)) {
                result[idx++] = products[i];
            }
        }
        return result;
    }

    @Override
    public Product[] getProducts() {
        int cnt = 0;
        for (int i = 0; i < pCount; i++) {
            if (!(products[i] instanceof Refrigerator)) {
                cnt++;
            }
        }

        Product[] result = new Product[cnt];
        int idx = 0;
        for (int i = 0; i < pCount; i++) {
            if (!(products[i] instanceof Refrigerator)) {
                result[idx++] = products[i];
            }
        }
        return result;
    }

    @Override
    public Refrigerator[] getRefrigerators() {
        int cnt = 0;
        for (int i = 0; i < pCount; i++) {
            if (products[i] instanceof Refrigerator) {
                cnt++;
            }
        }

        Refrigerator[] result = new Refrigerator[cnt];
        int idx = 0;
        for (int i = 0; i < pCount; i++) {
            if (products[i] instanceof Refrigerator) {
                result[idx++] = (Refrigerator) products[i];
            }
        }
        return result;
    }

    @Override
    public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
        int cnt = 0;
        for (int i = 0; i < pCount; i++) {
            if (products[i] instanceof Refrigerator) {
                if (((Refrigerator) products[i]).isFreezer() == freezer) {
                    cnt++;
                }
            }
        }

        Refrigerator[] result = new Refrigerator[cnt];
        int idx = 0;
        for (int i = 0; i < pCount; i++) {
            if (products[i] instanceof Refrigerator) {
                if (((Refrigerator) products[i]).isFreezer() == freezer) {
                    result[idx++] = (Refrigerator) products[i];
                }
            }
        }
        return result;
    }

    @Override
    public long getTotalPrice() {
        long sum = 0;
        for (int i = 0; i < pCount; i++) {
            sum += products[i].getPrice();
        }
        return sum;
    }

    @Override
    public boolean addReview(Review review) {
        if (rCount < MAX_REVIEW_SIZE) {
            reviews[rCount++] = review;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeReview(int reviewId) {
        for (int i = 0; i < rCount; i++) {
            if (reviews[i].getReviewId() == reviewId) {
                for (int j = i; j < rCount - 1; j++) {
                    reviews[j] = reviews[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Review[] getProductReview(String pCode) {
        int cnt = 0;
        for (int i = 0; i < rCount; i++) {
            if (reviews[i].getpCode() == pCode) {
                cnt++;
            }
        }

        Review[] result = new Review[cnt];
        int idx = 0;
        for (int i = 0; i < rCount; i++) {
            if (reviews[i].getpCode() == pCode) {
                result[idx++] = reviews[i];
            }
        }
        return result;
    }
}
