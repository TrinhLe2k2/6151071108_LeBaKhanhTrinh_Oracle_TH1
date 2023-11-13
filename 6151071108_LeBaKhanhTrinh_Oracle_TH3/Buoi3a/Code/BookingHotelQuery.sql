
-- a) List full details of all hotels.
SELECT * FROM HOTEL;

-- b) List the number of rooms in each hotel that are located in Hanoi.
SELECT h.hotelNo, h.hotelName, h.city, COUNT(r.roomNo) AS NumberOfRooms
FROM HOTEL h
LEFT JOIN ROOM r ON h.hotelNo = r.hotelNo
WHERE h.city = 'Hà N?i'
GROUP BY h.hotelNo, h.hotelName, h.city;

-- c) List all double and family rooms with a price below RM150 per night, in ascending order of price.
SELECT * FROM ROOM
WHERE type IN ('Double', 'Family') AND price < 150
ORDER BY price ASC;

-- d) List the details of all guests from Long An that make booking more than twice.
SELECT g.guestno, g.guestName, g.address, g.phone, COUNT(b.bookingNo) AS SoLanDatPhong
FROM GUEST g
JOIN BOOKING b ON g.guestNo = b.guestNo
WHERE g.address LIKE 'Long An'
GROUP BY g.guestNo, g.guestName, g.address, g.phone
HAVING COUNT(b.bookingNo) > 2;

-- e) List all the detail of guests who is make a booking at the Hilton Hotel, alphabetically order by name
SELECT g.guestNo, g.guestName, g.address, g.phone
FROM GUEST g
JOIN BOOKING b ON g.guestNo = b.guestNo
JOIN HOTEL h ON b.hotelNo = h.hotelNo
WHERE h.hotelName = 'Hilton'
ORDER BY g.guestName ASC;

-- f) Retrieve the average price of the room for each hotel.
SELECT h.hotelNo, h.hotelName, AVG(r.price) AS GiaPhongTrungBinh
FROM HOTEL h
JOIN ROOM r ON h.hotelNo = r.hotelNo
GROUP BY h.hotelNo, h.hotelName;

-- g) Update the price for all rooms with a rise of 5%.
UPDATE ROOM
SET price = price * 1.05;
