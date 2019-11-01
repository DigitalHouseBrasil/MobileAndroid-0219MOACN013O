
package br.com.digitalhouse.mercadolivreapp.digitalhouse.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Na classe Result além das anotações criadas a partir da conversão do json para o pojo
 * temos também as anotação para o banco de dados, nessa classe podemos ver a anotação
 * @Entity que irá dizer que a classe será uma tabela chamada "result
 * e a @PrimaryKey que irá determinar a chave primaria para essa tabela
 */
@Entity(tableName = "result")
public class Result {

    @PrimaryKey(autoGenerate = true)
    private long key;

    @SerializedName("accepts_mercadopago")
    private Boolean acceptsMercadopago;
    @Expose
    private Address address;
    @Expose
    private List<Attribute> attributes;
    @SerializedName("available_quantity")
    private Long availableQuantity;
    @SerializedName("buying_mode")
    private String buyingMode;
    @SerializedName("catalog_product_id")
    private Object catalogProductId;
    @SerializedName("category_id")
    private String categoryId;
    @Expose
    private String condition;
    @SerializedName("currency_id")
    private String currencyId;
    @Expose
    private String id;
    @Expose
    private Installments installments;
    @SerializedName("listing_type_id")
    private String listingTypeId;
    @SerializedName("official_store_id")
    private Long officialStoreId;
    @SerializedName("original_price")
    private Double originalPrice;
    @Expose
    private String permalink;
    @Expose
    private Double price;
    @Expose
    private Reviews reviews;
    @Expose
    private Seller seller;
    @SerializedName("seller_address")
    private SellerAddress sellerAddress;
    @Expose
    private Shipping shipping;
    @SerializedName("site_id")
    private String siteId;
    @SerializedName("sold_quantity")
    private Long soldQuantity;
    @SerializedName("stop_time")
    private String stopTime;
    @Expose
    private List<String> tags;
    @Expose
    private String thumbnail;
    @Expose
    private String title;


    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public Boolean getAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getBuyingMode() {
        return buyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    public Object getCatalogProductId() {
        return catalogProductId;
    }

    public void setCatalogProductId(Object catalogProductId) {
        this.catalogProductId = catalogProductId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    public Long getOfficialStoreId() {
        return officialStoreId;
    }

    public void setOfficialStoreId(Long officialStoreId) {
        this.officialStoreId = officialStoreId;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public SellerAddress getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
