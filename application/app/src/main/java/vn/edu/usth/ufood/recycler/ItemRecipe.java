package vn.edu.usth.ufood.recycler;

public class ItemRecipe {
    String time;
    String recipe;
    String img;

    String price;
    float rating;

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String money) {
        this.price = money;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }
}
