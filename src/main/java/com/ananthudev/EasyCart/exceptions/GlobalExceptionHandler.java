package com.ananthudev.EasyCart.exceptions;

import com.ananthudev.EasyCart.exceptions.cart.CartItemNotFoundException;
import com.ananthudev.EasyCart.exceptions.cart.CartNotFoundException;
import com.ananthudev.EasyCart.exceptions.category.CategoryInvalidCredentialException;
import com.ananthudev.EasyCart.exceptions.category.CategoryNotFoundException;
import com.ananthudev.EasyCart.exceptions.category.DuplicateCategoryFoundException;
import com.ananthudev.EasyCart.exceptions.customer.CustomerInvalidCredentialException;
import com.ananthudev.EasyCart.exceptions.customer.CustomerNotFoundException;
import com.ananthudev.EasyCart.exceptions.customer.DuplicateCustomerException;
import com.ananthudev.EasyCart.exceptions.delivery.InvalidDeliveryAddressException;
import com.ananthudev.EasyCart.exceptions.discount.DiscountExpiredException;
import com.ananthudev.EasyCart.exceptions.discount.DiscountNotApplicableException;
import com.ananthudev.EasyCart.exceptions.discount.DiscountNotFoundException;
import com.ananthudev.EasyCart.exceptions.notification.NotificationNotFoundException;
import com.ananthudev.EasyCart.exceptions.notification.NotificationSendFailedException;
import com.ananthudev.EasyCart.exceptions.order.InvalidOrderException;
import com.ananthudev.EasyCart.exceptions.order.OrderAlreadyProcessedException;
import com.ananthudev.EasyCart.exceptions.order.OrderNotFoundException;
import com.ananthudev.EasyCart.exceptions.payment.InvalidPaymentMethodException;
import com.ananthudev.EasyCart.exceptions.payment.PaymentFailedException;
import com.ananthudev.EasyCart.exceptions.product.InvalidProductDataException;
import com.ananthudev.EasyCart.exceptions.product.OutOfStockException;
import com.ananthudev.EasyCart.exceptions.product.ProductNotFoundException;
import com.ananthudev.EasyCart.exceptions.review.DuplicateReviewException;
import com.ananthudev.EasyCart.exceptions.review.ReviewNotFoundException;
import com.ananthudev.EasyCart.exceptions.seller.DuplicateSellerException;
import com.ananthudev.EasyCart.exceptions.seller.SellerInvalidCredentialException;
import com.ananthudev.EasyCart.exceptions.seller.SellerNotFoundException;
import com.ananthudev.EasyCart.exceptions.wishlist.WishlistNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    Customer exceptions

    @ExceptionHandler(DuplicateCustomerException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateCustomer(DuplicateCustomerException duplicateCustomerException){
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","Duplicate customer");
        errorBody.put("message",duplicateCustomerException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","customer not found");
        errorBody.put("message",customerNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerInvalidCredentialException.class)
    public ResponseEntity<Map<String,Object>> handleCustomerInvalidCredentialException(CustomerInvalidCredentialException customerInvalidCredentialException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid credential for customers");
        errorBody.put("message",customerInvalidCredentialException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

//  Seller exceptions

    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleSellerNotFoundException(SellerNotFoundException sellerNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","seller not found");
        errorBody.put("message",sellerNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateSellerException.class)
    public ResponseEntity<Map<String,Object>> handleDuplicateSellerException(DuplicateSellerException duplicateSellerException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","seller already exist with given email");
        errorBody.put("message",duplicateSellerException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(SellerInvalidCredentialException.class)
    public ResponseEntity<Map<String,Object>> handleSellerInvalidCredentialException(SellerInvalidCredentialException sellerInvalidCredentialException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid credential for sellers");
        errorBody.put("message",sellerInvalidCredentialException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);

    }

//    Product exceptions
    @ExceptionHandler(InvalidProductDataException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidProductDataException(InvalidProductDataException invalidProductDataException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid data");
        errorBody.put("message",invalidProductDataException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<Map<String,Object>> handleOutOfStockException(OutOfStockException outOfStockException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","no data present");
        errorBody.put("message",outOfStockException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",productNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

//    Category exceptions

    @ExceptionHandler(CategoryInvalidCredentialException.class)
    public ResponseEntity<Map<String,Object>> handleCategoryInvalidCredentialException(CategoryInvalidCredentialException categoryInvalidCredentialException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid data");
        errorBody.put("message",categoryInvalidCredentialException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCategoryNotFoundException(CategoryNotFoundException categoryNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",categoryNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateCategoryFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDuplicateCategoryFoundException(DuplicateCategoryFoundException duplicateCategoryFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","duplicate data");
        errorBody.put("message",duplicateCategoryFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

//    Cart exceptions

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCartNotFoundException(CartNotFoundException cartNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",cartNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCartItemNotFoundException(CartItemNotFoundException cartItemNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",cartItemNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


//    Order Exception

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleOrderNotFoundException(OrderNotFoundException orderNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",orderNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidOrderException(InvalidOrderException invalidOrderException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid data");
        errorBody.put("message",invalidOrderException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderAlreadyProcessedException.class)
    public ResponseEntity<Map<String,Object>> handleOrderAlreadyProcessedException(OrderAlreadyProcessedException orderAlreadyProcessedException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","already processed");
        errorBody.put("message",orderAlreadyProcessedException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

//    Payment exceptions

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<Map<String,Object>> handlePaymentFailedException(PaymentFailedException paymentFailedException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","payment failed");
        errorBody.put("message",paymentFailedException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPaymentMethodException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidPaymentMethodException(InvalidPaymentMethodException invalidPaymentMethodException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid payment");
        errorBody.put("message",invalidPaymentMethodException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

//    Review exceptions


    @ExceptionHandler(DuplicateReviewException.class)
    public ResponseEntity<Map<String,Object>> handleDuplicateReviewException(DuplicateReviewException duplicateReviewException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","duplicate data");
        errorBody.put("message",duplicateReviewException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleReviewNotFoundException(ReviewNotFoundException reviewNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",reviewNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

//    Wishlist exceptions

    @ExceptionHandler(WishlistNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleWishlistNotFoundException(WishlistNotFoundException wishlistNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",wishlistNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WishlistNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleWishlistItemNotFoundException(WishlistNotFoundException wishlistNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",wishlistNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


//    Notification exceptions

    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotificationNotFound(NotificationNotFoundException notificationNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",notificationNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotificationSendFailedException.class)
    public ResponseEntity<Map<String,Object>> handleNotificationSendFailed(NotificationSendFailedException notificationSendFailedException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","failed to send");
        errorBody.put("message",notificationSendFailedException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


//    Discount exceptions

    @ExceptionHandler(DiscountExpiredException.class)
    public ResponseEntity<Map<String,Object>> handleDiscountExpiredException(DiscountExpiredException discountExpiredException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","discount expired");
        errorBody.put("message",discountExpiredException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(DiscountNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDiscountNotFoundException(DiscountNotFoundException discountNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not found");
        errorBody.put("message",discountNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(DiscountNotApplicableException.class)
    public ResponseEntity<Map<String,Object>> handleDiscountNotApplicableException(DiscountNotApplicableException discountNotApplicableException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","not applicable");
        errorBody.put("message",discountNotApplicableException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

//    Delivery Exceptions

    @ExceptionHandler(InvalidDeliveryAddressException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidDeliveryAddressException(InvalidDeliveryAddressException invalidDeliveryAddressException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid data");
        errorBody.put("message",invalidDeliveryAddressException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


//generic exception
    public ResponseEntity<Map<String,Object>> handleGenericException(Exception exception){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorBody.put("error", "Internal Server Error");
        errorBody.put("message", exception.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
