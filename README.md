# 🛒 Cart & Order Management API
🇺🇸 English | 🇧🇷 [Português](README.pt-BR.md)

A cart and order management system designed to simulate the basic backend functionality of an e-commerce platform.

The project allows users to add products to a cart, manage items, and place orders.

The system was designed following Domain-Driven Design (DDD) principles and REST API best practices.

## 📌 Features

👤 User registration  
🛍️ Product management  
🛒 Cart creation and management  
➕ Add products to the cart  
🔢 Item quantity control  
💰 Automatic cart total calculation  
📦 Order creation  
📊 Order status tracking  
📉 Stock management  

## 🏗️ System Modeling

The system structure was modeled using UML, as shown in the diagram below:

<img width="708" height="1100" alt="image" src="https://github.com/user-attachments/assets/c5d1b102-49d8-4483-acc4-031c535fbdb0" />

## 🔄 System Flow

1️⃣ A user is created  
2️⃣ The user owns a cart  
3️⃣ Products are added as `CartItem`  
4️⃣ The cart calculates the total value  
5️⃣ The user completes the purchase  
6️⃣ An order is created using the cart data  

## 🧮 Business Rules

- The product price is copied to `priceAtMoment` when the item is added to the cart.
- The cart total is calculated as the sum of all item subtotals.
- Product stock must be checked before adding an item to the cart.
- An order status can change according to the payment flow.

## 📊 UML Diagram

The system was modeled with the following relationships:

- `User` → `Cart` (1:1)  
- `Cart` → `CartItem` (1:N)  
- `Product` → `CartItem` (1:N)  
- `User` → `Order` (1:N)

## 🚀 Possible Improvements

- Implement payment integration
- Add promotions / coupon system
- Create product category management
- Implement product caching
- Add JWT authentication

## 📚 Project Purpose

This project was developed with the goal of practicing:

- Domain modeling
- REST API design
- E-commerce business rule implementation
- Backend architecture concepts
