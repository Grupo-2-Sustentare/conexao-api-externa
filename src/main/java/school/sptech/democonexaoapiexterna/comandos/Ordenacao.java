package school.sptech.democonexaoapiexterna.comandos;

import school.sptech.democonexaoapiexterna.dto.BancoMockDto;

public class Ordenacao {
    public static int calcularQtdItem(BancoMockDto[] lista, String buscaNome ) {
        return calcularQtdItemAux(lista, 0, buscaNome, 0);
    };

    private static int calcularQtdItemAux(BancoMockDto[] lista, int index, String buscaNome, int numeroDeItens) {
        if (index >= lista.length) {
            return 0;
        }

        String nomeItem = lista[index].getNome();

        if (nomeItem.equalsIgnoreCase(buscaNome)) {
            return ( numeroDeItens++ + calcularQtdItemAux(lista, index + 1, buscaNome, numeroDeItens) );
        }
        return calcularQtdItemAux(lista, index + 1, buscaNome, numeroDeItens);
    }

    public static void mergeSort(BancoMockDto[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        BancoMockDto[] temp = new BancoMockDto[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(BancoMockDto[] arr, BancoMockDto[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(BancoMockDto[] arr, BancoMockDto[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i].getDiasVencimento() <= temp[j].getDiasVencimento()) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
    public static void quickSort(BancoMockDto[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(BancoMockDto[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(BancoMockDto[] arr, int low, int high) {
        int pivot = arr[high].getConversaoPadrao();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getConversaoPadrao() <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(BancoMockDto[] arr, int i, int j) {
        BancoMockDto temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int pesquisaBinaria(BancoMockDto[] arr, int t) {
        int esq = 0;
        int dir = arr.length - 1;

        while (esq <= dir) {
            int media = esq + (dir - esq) / 2;
            int valorMedia = arr[media].getId();

            if (valorMedia == t) {
                return media;
            }
            if (valorMedia > t) {
                dir = media - 1;
            } else {
                esq = media + 1;
            }
        }
        return -1;
    }

}
