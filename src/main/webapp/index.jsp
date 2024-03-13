<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>

<html>
    <body>
        <h2>Budget Tracker</h2>

        <div class="container-fluid">
            <form>
                <h3>Inflows</h3>

                <table>
                    <tr>
                        <th>Type</th>
                        <th>Total</th>
                        <th>Add</th>
                    </tr>

                    <tr>
                        <td>Basic Pay</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Other Inflows (gifts, refunds, etc.)</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <th>Total Net Inflows</th>
                        <th></th>
                    </tr>
                </table>

                <h3>Outflows</h3>

                <table>
                    <tr>
                        <th>Type</th>
                        <th>Total</th>
                        <th>Add</th>
                    </tr>

                    <tr>
                        <th>Savings/Investments</th>
                    </tr>

                    <tr>
                        <td>Emergency Fund</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Retirement Accounts</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Other</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <th>Debt</th>
                    </tr>

                    <tr>
                        <td>Credit Cards</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Loans</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <th>Home</th>
                    </tr>

                    <tr>
                        <td>Food/Groceries</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Rent</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Utilities</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Phone</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Property Insurance</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <th>Transportation</th>
                    </tr>

                    <tr>
                        <td>Auto Insurance</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Gas</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Vehicle Maintenance</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Other (Registration/License Fees)</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <th>Recreation/Entertainment</th>
                    </tr>

                    <tr>
                        <td>Vacations</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Entertainment/Dining Out</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Hobbies</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Subscription Fees</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <td>Other</td>
                        <td></td>
                        <td><input type="text"></td>
                    </tr>

                    <tr>
                        <th>Total Outflows</th>
                        <th></th>
                    </tr>
                </table>

                <h3>Calculate Cash Flow</h3>

                <table>
                    <tr>
                        <td>Total Net Inflows</td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>Less Total Outflows</td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>Net Cash Flow (Deficit)</td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>