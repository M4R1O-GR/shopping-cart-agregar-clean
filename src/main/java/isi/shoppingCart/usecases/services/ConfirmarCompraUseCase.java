package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.Cart;
import isi.shoppingCart.usecases.ports.CartRepository;

public class ConfirmarCompraUseCase {
    private CartRepository cartRepository;

    public ConfirmarCompraUseCase(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public String execute() {
        Cart cart = cartRepository.getCart();

        if (cart.getItems().isEmpty()) {
            return "El carrito está vacío. Agrega productos antes de confirmar la compra.";
        }

        double total = cart.getTotal();
        cart.clear();
        cartRepository.save(cart);

        return "Compra confirmada exitosamente. Total pagado: $ " + total;
    }
}
