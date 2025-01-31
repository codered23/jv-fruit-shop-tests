package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void calculate(Transaction transaction) {
        int oldQuantity = Storage.fruitsStorage.get(transaction.getFruit());
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Invalid return data of fruit: " + transaction.getFruit());
        }
        Storage.fruitsStorage.put(transaction.getFruit(), transaction.getQuantity() + oldQuantity);
    }
}
